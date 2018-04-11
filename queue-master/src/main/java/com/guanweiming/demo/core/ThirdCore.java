package com.guanweiming.demo.core;

/**
 * @author chezhu.xin
 */
public class ThirdCore extends BaseCore {


    /**
     * 传递最后一次放的位置，计算下次应该怎么放
     *
     * @param array
     * @param x
     * @param y
     * @return
     */
    @Override
    public ActionEnum getDirection(StatusEnum[][] array, int x, int y, StatusEnum next, ActionEnum preAction) {
        if (x >= WIDTH) {
            return ActionEnum.NEW;
        }
        if (x % 2 == 0 && y == 2) {
            return ActionEnum.NEW;
        }
        if (x % 2 == 1 && y == 1) {
            return ActionEnum.NEW;
        }
        /*往下走*/
        return ActionEnum.DOWN;
    }


}
