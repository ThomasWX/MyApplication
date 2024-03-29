// (c)2016 Flipboard Inc, All Rights Reserved.

package com.hc.network.api;

import java.util.List;
import com.hc.model.ZhuangbiImage;
import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Observable;

public interface ZhuangbiApi {
    @GET("search")
    Observable<List<ZhuangbiImage>> search(@Query("q") String query);
}
