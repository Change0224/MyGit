package com.guanweiming.demo.core;

/**
 * @author chezhu.xin
 */
public class FirstCore extends BaseCore {


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
        StatusEnum current = array[y][x];
        StatusEnum up = y > 0 ? array[y - 1][x] : StatusEnum.BLANK;
        StatusEnum down = y + 1 < HEIGHT ? array[y + 1][x] : StatusEnum.RED;

        /*颜色不同，另起一行*/
        if (next.getCode() != current.getCode()) {
            return ActionEnum.NEW;
        }
        /*到达底部*/
        if (down != null) {
            return ActionEnum.RIGHT;
        }
        /*往下走*/
        return ActionEnum.DOWN;
    }


}
