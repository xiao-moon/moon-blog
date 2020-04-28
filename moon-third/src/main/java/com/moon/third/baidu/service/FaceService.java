package com.moon.third.baidu.service;


import com.moon.third.baidu.api.BaiduAi;
import com.moon.third.baidu.api.FaceAPI;
import com.moon.third.baidu.bean.face.FaceDetectResult;

/**
 * Created by Administrator on 2018/6/21.
 */
public class FaceService {

    public static FaceDetectResult faceDetect_localPath(String path){
        String json = FaceAPI.faceDetect(path, BaiduAi.IMG_TYPE.BASE64);
        return  FaceDetectResult.create(json);
    }

    public static void main(String[] args){
        String path="C:\\Users\\Administrator\\Desktop\\111.jpg";
        FaceDetectResult result=faceDetect_localPath(path);
        System.out.println(result);
    }
}
