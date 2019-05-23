package com.voxyle.wanandroid.net;

import com.voxyle.wanandroid.bean.ArticleData;
import com.voxyle.wanandroid.bean.BannerData;
import com.voxyle.wanandroid.bean.ChaptersData;
import com.voxyle.wanandroid.bean.CollectWeb;
import com.voxyle.wanandroid.bean.FriendData;
import com.voxyle.wanandroid.bean.HotKey;
import com.voxyle.wanandroid.bean.NaviData;
import com.voxyle.wanandroid.bean.PrimaryTree;
import com.voxyle.wanandroid.bean.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WanAndroidApi {
    /**
     * 公众号历史数据
     *
     * @param id
     * @param page
     * @return
     */
    @GET("/wxarticle/list/{id}/{page}/json")
    Call<Response<List<ArticleData>>> articleHistory(@Path("id") int id, @Path("page") int page);

    /**
     * 搜索公众号历史
     *
     * @param id
     * @param page 从1开始
     * @param k
     * @return
     */
    @GET("/wxarticle/list/{id}/{page}/json?")
    Call<Response<List<ArticleData>>> articleSearch(@Path("id") int id, @Path("page") int page, @Query("k") String k);

    /**
     * 置顶文章
     *
     * @return
     */
    @GET("/article/top/json")
    Call<Response<List<ArticleData>>> articleTop();

    /**
     * 首页
     *
     * @param page 从0开始
     * @return
     */
    @GET("/article/list/{page}/json")
    Call<Response<List<ArticleData>>> article(@Path("page") int page);

    /**
     * banner
     *
     * @return
     */
    @GET("/banner/json")
    Call<Response<List<BannerData>>> banner();

    /**
     * 常用网站
     *
     * @return
     */
    @GET("/friend/json")
    Call<Response<List<FriendData>>> friend();

    /**
     * 搜索热词
     *
     * @return
     */
    @GET("/hotkey/json")
    Call<Response<List<HotKey>>> hotkey();

    /**
     * 体系树
     *
     * @return
     */
    @GET("/tree/json")
    Call<Response<List<PrimaryTree>>> tree();

    /**
     * 体系下文章
     *
     * @param cid
     * @param page 从0开始
     * @return
     */
    @GET("/article/list/{page}/json?")
    Call<Response<ArticleData>> articleOfTree(@Query("cid") int cid, @Path("page") int page);

    /**
     * 导航数据
     *
     * @return
     */
    @GET("/navi/json")
    Call<Response<NaviData>> navi();

    /**
     * 项目分类
     *
     * @return
     */
    @GET("/project/tree/json")
    Call<Response<ChaptersData>> projectOfTree();

    /**
     * 项目列表
     * 从1开始
     *
     * @return
     */
    @GET("/project/list/{page}/json?cid=294")
    Call<Response<ArticleData>> projectList(@Query("cid") int cid, @Path("page") int page);

    /**
     * 登录
     *
     * @return
     */
    @POST("/user/login")
    @FormUrlEncoded
    Call<Response> login(@Field("username") String uName, @Field("password") String pWord);

    /**
     * 注册
     *
     * @param uName
     * @param pWord
     * @param reWord
     * @return
     */
    @POST("/user/register")
    @FormUrlEncoded
    Call<Response> register(@Field("username") String uName, @Field("password") String pWord, @Field("repassword") String reWord);

    /**
     * 退出
     *
     * @return
     */
    @GET("/user/logout/json")
    @Headers({"max-Age : 0"})
    Call<Response> logout();

    /**
     * 我的收藏
     *
     * @param page 从0开始
     * @return
     */
    @GET("/lg/collect/list/{page}/json")
    Call<Response<ArticleData>> collectList(@Path("page") int page);

    /**
     * 收藏站内文章
     *
     * @param originId
     * @return
     */
    @POST("/lg/collect/{originId}/json")
    Call<Response> addCollectOfInside(@Path("originId") int originId);

    /**
     * 收藏站外文章
     *
     * @param title  标题
     * @param author 作者
     * @param link   链接
     * @return
     */
    @POST("/lg/collect/add/json")
    @FormUrlEncoded
    Call<Response> addCollectOfOuter(@Field("title") String title, @Field("author") String author, @Field("link") String link);

    /**
     * 文章中取消收藏
     *
     * @param id
     * @return
     */
    @POST("/lg/uncollect_originId/{id}/json")
    Call<Response> unCollect(@Path("id") int id);

    /**
     * 收藏页取消收藏
     *
     * @return
     */
    @POST("/lg/uncollect_originId/{id}/json")
    @FormUrlEncoded
    Call<Response> unCollect(@Path("id") int id, @Field("originId") int originId);

    /**
     * 收藏的网站列表
     *
     * @return
     */
    @GET("/lg/collect/usertools/json")
    Call<CollectWeb> collectOfWeb();

    /**
     * 添加收藏网站
     *
     * @param name
     * @param link
     * @return
     */
    @POST("/lg/collect/addtool/json")
    @FormUrlEncoded
    Call<Response> addCollectOfWeb(@Field("name") String name, @Field("link") String link);

    /**
     * 编辑收藏网站
     *
     * @param id
     * @param name
     * @param link
     * @return
     */
    @POST("/lg/collect/updatetool/json")
    @FormUrlEncoded
    Call<Response> updateCollectOfWeb(@Field("id") int id, @Field("name") String name, @Field("link") String link);

    /**
     * 删除收藏网站
     *
     * @param id
     * @return
     */
    @POST("/lg/collect/deletetool/json")
    @FormUrlEncoded
    Call<Response> deleteCollectOfWeb(@Field("id") int id);

    /**
     *
     * @param page 从0开始
     * @param k
     * @return
     */
    @POST("/article/query/{page}/json")
    @FormUrlEncoded
    Call<Response<ArticleData>> search(@Path("page") int page, @Field("k") String k);
}