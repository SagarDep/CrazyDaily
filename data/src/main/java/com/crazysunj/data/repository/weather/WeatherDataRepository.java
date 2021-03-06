/*
  Copyright 2017 Sun Jian
  <p>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  <p>
  http://www.apache.org/licenses/LICENSE-2.0
  <p>
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package com.crazysunj.data.repository.weather;

import com.crazysunj.data.api.HttpHelper;
import com.crazysunj.data.service.WeatherService;
import com.crazysunj.data.util.RxTransformerUtil;
import com.crazysunj.domain.repository.weather.WeatherRepository;
import com.google.gson.JsonObject;

import javax.inject.Inject;

import io.reactivex.Flowable;
import retrofit2.Response;

/**
 * @author: sunjian
 * created on: 2017/9/19 下午6:58
 * description: https://github.com/crazysunj/CrazyDaily
 */
public class WeatherDataRepository implements WeatherRepository {

    private WeatherService mWeatherService;

    @Inject
    public WeatherDataRepository(HttpHelper httpHelper) {
        mWeatherService = httpHelper.getWeatherService();
    }

    @Override
    public Flowable<JsonObject> getWeatherList(String key, String location, String language, String unit) {
        return mWeatherService.getWeatherList(key, location, language, unit)
                .map(Response::body)
                .compose(RxTransformerUtil.normalTransformer());
    }
}
