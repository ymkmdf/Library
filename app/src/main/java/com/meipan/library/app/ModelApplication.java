package com.meipan.library.app;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

/**
 * Created by gaoyan on 17/3/1.
 */

public class ModelApplication extends MultiDexApplication {

    private static final String TAG="cangshuge";
    boolean mSplashed;
//    AccessToken mAccessToken;
//    User mUser;
    @Override
    public void onCreate() {
        super.onCreate();
        //是不是第一次打开此app
//        initSplashed();
        //缓存文件
//        initCache();

//        initUser();

//        initAccessToken();
    }

    private void initCache(){
//        try {
//            FileUtils.mkdirs(new File(Constants.IMAGE_CACHE_ROOT));
//        }catch (FileUtils.CreateDirectoryException e){
//            Log.e(TAG,"initCache",e);
//        }
    }

//    public void logout(){
//        putAccessToken(null);
//        putUser(null);
//    }

//    private void initUser(){
//        final String user_text=PreferencesUtils.getString(this,"user_text");
//        if (!TextUtils.isEmpty(user_text)){
//            mUser = JSON.parseObject(user_text,User.class);
//        }else{
//            mUser = null;
//        }
//    }

//    public void putUser(User user){
//        String user_text="";
//        if(user !=null){
//            user_text=JSON.toJSONString(user);
//        }
//        PreferencesUtils.putString(this,"user_text",user_text);
//        mUser=user;
//    }

//    public User getUser(){return mUser;}

//    private void initAccessToken(){
//        final String access_token=PreferencesUtils.getString(this,"access_token");
//        if (!TextUtils.isEmpty(access_token)){
//            mAccessToken=JSON.parseObject(access_token, AccessToken.class);
//        }else {
//            mAccessToken=null;
//        }
//    }

//    public void putAccessToken(AccessToken accessToken){
//        String access_token="";
//        if (accessToken!=null){
//            access_token=JSON.toJSONString(accessToken);
//        }
//        PreferencesUtils.putString(this,"access_token",access_token);
//        mAccessToken=accessToken;
//    }
//    public AccessToken getAccessToken(){return mAccessToken;}



//    private void initSplashed(){ mSplashed= PreferencesUtils.getBoolean(this,"splashed"); }
//
//    public boolean getSplashed(){return mSplashed;}
//
//    public void putSplashed(boolean splashed){
//        PreferencesUtils.putBoolean(this,"splashed",splashed);
//        mSplashed=splashed;
//    }
//
//    public String getAuthorization(){
//        return mAccessToken == null ? "Bearer unsign" : mAccessToken.getAuthorization();
//    }
}
