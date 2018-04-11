package com.guanweiming.demo.core;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chezhu.xin
 */
public abstract class BaseCore implements ICore {
    List<StatusEnum> STATUS_LIST = Lists.newArrayList();

    @Override
    public void red() {
        STATUS_LIST.add(StatusEnum.RED);
    }

    @Override
    public void blue() {
        STATUS_LIST.add(StatusEnum.BLUE);
    }

    @Override
    public void undo() {
        if (STATUS_LIST.size() > 0) {
            STATUS_LIST.remove(STATUS_LIST.size() - 1);
        }
    }

    @Override
    public StatusEnum[][] getStatusEnum() {
        if (STATUS_LIST.size() == 0) {
            return new StatusEnum[HEIGHT][WIDTH];
        }
        StatusEnum[][] result = new StatusEnum[HEIGHT][WIDTH];
        /*当前列*/
        int column = 0;

        int preX = column;
        int preY = 0;

        /*放第一个*/
        result[preY][preX] = STATUS_LIST.get(0);

        ActionEnum preAction = null;


        for (int i = 1; i < STATUS_LIST.size(); i++) {
            /*当前需要放的数据*/
            StatusEnum statusEnum = STATUS_LIST.get(i);

            ActionEnum actionEnum = getDirection(result, preX, preY, statusEnum, preAction);
            switch (actionEnum) {
                case NEW:
                    /*另起一列*/
                    /*后面的重置为空*/
                    if (preX > column) {
                        for (int j = preX + 1; j < WIDTH; j++) {
                            result[preY][j] = StatusEnum.BLANK;
                        }
                    }
                    column++;
                    preX = column;
                    preY = 0;
                    preAction = ActionEnum.NEW;
                    break;
                case DOWN:
                    preY++;
                    preAction = ActionEnum.DOWN;
                    break;
                case RIGHT:
                    preX++;
                    preAction = ActionEnum.RIGHT;
                    break;
                default:
            }
            if (preY < HEIGHT && preX < WIDTH) {
                result[preY][preX] = statusEnum;
            }
//            print(result);
        }
//        for (int i = 0; i < STATUS_LIST.size(); i++) {
//            System.out.print(STATUS_LIST.get(i).getDesc() + "\t");
//        }
        System.out.println();
        System.out.println();
        print(result);

        return result;
    }

    void print(StatusEnum[][] result) {
        if (true) {
//            return;
        }
        for (int i = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result[i].length; i1++) {
                System.out.print((result[i][i1] == null ? StatusEnum.BLANK.getDesc() : result[i][i1].getDesc()) + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }
}
