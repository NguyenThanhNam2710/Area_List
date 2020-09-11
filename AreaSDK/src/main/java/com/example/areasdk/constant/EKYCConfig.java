package com.example.areasdk.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vannh.lvt on 15/07/2020
 */
public class EKYCConfig {
    private static Integer width;
    private static Integer height;
    private static Integer numberOfActions;
    private static Integer imageQuality;
    private static List<String> actions = new ArrayList<>();
    private static boolean callAPIConfigure;

    public static boolean isCallAPIConfigure() {
        return callAPIConfigure;
    }

    public static void setCallAPIConfigure(boolean callAPIConfigure) {
        EKYCConfig.callAPIConfigure = callAPIConfigure;
    }

    public static void setWidth(Integer width) {
        if (width == null)
            width = 500;
        EKYCConfig.width = width;
    }

    public static void setHeight(Integer height) {
        if (height == null)
            height = 500;
        EKYCConfig.height = height;
    }

    public static void setNumberOfActions(Integer numberOfActions) {
        if (numberOfActions == null)
            numberOfActions = 3;
        EKYCConfig.numberOfActions = numberOfActions;
    }

    public static void setImageQuality(Integer imageQuality) {
        if (imageQuality == null)
            imageQuality = 95;
        EKYCConfig.imageQuality = imageQuality;
    }

    public static void setActions(List<String> actions) {
        EKYCConfig.actions.clear();
        if (actions == null) {
            EKYCConfig.actions.add("turn_left");
            EKYCConfig.actions.add("turn_right");
            EKYCConfig.actions.add("smile");
            EKYCConfig.actions.add("face_down");
            EKYCConfig.actions.add("blink");
            EKYCConfig.actions.add("tilt_head_left");
            EKYCConfig.actions.add("tilt_head_right");
            EKYCConfig.actions.add("close_eyes");
            return;
        }
        EKYCConfig.actions.addAll(actions);
    }


    public static Integer getWidth() {
        return width;
    }

    public static Integer getHeight() {
        return height;
    }

    public static Integer getNumberOfActions() {
        return numberOfActions;
    }

    public static Integer getImageQuality() {
        return imageQuality;
    }

    public static List<String> getActions() {
        return actions;
    }
}
