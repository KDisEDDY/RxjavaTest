package project.ljy.rxjavatest.network;

/**
 * Title: VideoListModel
 * Description: 视频模块Model
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/3/31
 * Version: 1.0
 */

public class VideoListModel extends BaseRequest{

    public void getVideoListRequest(Callable callable){
        request(UrlConstant.GET_MOVIE_LIST, null, callable);
    }


}
