package com.nyc.guideme.models;

import java.util.List;

/**
 * Created by Wayne Kellman on 3/5/18.
 */

public class FoodListSingleton {
    private static FoodListSingleton FoodListSingleton;
    private List<FoodStampOfficeModel> foodStampOfficeModelList;
    private boolean checkInit;

    public static FoodListSingleton getInstance() {
        if (FoodListSingleton == null) {
            FoodListSingleton = new FoodListSingleton();
            return FoodListSingleton;
        }
        return FoodListSingleton;

    }

    public boolean isCheckInit() {
        return checkInit;
    }

    public void setCheckInit(boolean checkInit) {
        this.checkInit = checkInit;
    }

    public void setFoodStampOfficeModelList(List<FoodStampOfficeModel> foodStampOfficeModelList) {
        this.foodStampOfficeModelList = foodStampOfficeModelList;
    }

    public List<FoodStampOfficeModel> getFoodStampOfficeModelList() {
        return foodStampOfficeModelList;
    }

}
