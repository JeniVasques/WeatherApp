package com.example.findinglogs.viewmodel;


import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.findinglogs.model.model.Weather;
import com.example.findinglogs.model.repo.Repository;
import com.example.findinglogs.model.repo.remote.api.WeatherCallback;
import com.example.findinglogs.model.util.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();
    private static final int FETCH_INTERVAL = 120_000;
    private final Repository mRepository;
    private final MutableLiveData<List<Weather>> _weatherList = new MutableLiveData<>(new ArrayList<>());
    private final LiveData<List<Weather>> weatherList = _weatherList;

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable fetchRunnable = this::fetchAllForecasts;

    public MainViewModel(Application application) {
        super(application);
        mRepository = new Repository(application);
        startFetching();
    }

    //Implementação do botão de Atualizar os dados do tempo
    public void atualizarPagina() {
        handler.removeCallbacks(fetchRunnable);
        fetchAllForecasts();
    }


    public LiveData<List<Weather>> getWeatherList() {
        return weatherList;
    }

    private void startFetching() {
        fetchAllForecasts();
        handler.postDelayed(fetchRunnable, FETCH_INTERVAL);
    }

    private void fetchAllForecasts() {
        if (Logger.ISLOGABLE) Logger.d(TAG, "fetchAllForecasts()");
        HashMap<String, String> localizations = mRepository.getLocalizations();
        HashMap<String, Weather> weatherMap = new HashMap<>();
        final int total = localizations.size();
        final int[] count = {0};

        for (String latlon : localizations.values()) {
            mRepository.retrieveForecast(latlon, new WeatherCallback() {
                @Override
                public void onSuccess(Weather result) {
                    count[0]++;
                    weatherMap.put(result.getName(), result);

                    if (count[0] == total) {
                        _weatherList.setValue(new ArrayList<>(weatherMap.values()));
                        handler.postDelayed(fetchRunnable, FETCH_INTERVAL);
                    }
                }

                @Override
                public void onFailure(String error) {
                    count[0]++;
                    if (count[0] == total) {
                        _weatherList.setValue(new ArrayList<>(weatherMap.values()));
                        handler.postDelayed(fetchRunnable, FETCH_INTERVAL);
                    }
                }
            });
        }
    }



    @Override
    protected void onCleared() {
        handler.removeCallbacks(fetchRunnable);
        super.onCleared();
    }

    public void retrieveForecast(String latLon, WeatherCallback callback) {
        mRepository.retrieveForecast(latLon, callback);
    }
}