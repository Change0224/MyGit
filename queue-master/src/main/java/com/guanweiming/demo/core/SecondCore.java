package com.guanweiming.demo.core;

/**
 * @author chezhu.xin
 */
public class SecondCore extends BaseCore {
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
        StatusEnum down = y + 1 < HEIGHT ? array[y + 1][x] : StatusEnum.RED;
        StatusEnum current = array[y][x];
        StatusEnum up = y > 0 ? array[y - 1][x] : StatusEnum.BLANK;
        if (preAction == ActionEnum.RIGHT) {
            up = array[y][x - 1];
        }


        boolean isAAAA = true;
        if (up != null) {
            isAAAA = current.getCode() == up.getCode();
        }

        /*颜色不符合规则，另起一行*/
        if (y >= 1 && ((isAAAA && next.getCode() != current.getCode()) || (!isAAAA && next.getCode() == current.getCode()))) {
            return ActionEnum.NEW;
        }
        if (x + 1 >= WIDTH) {
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
