package com.guanweiming.demo.core;

/**
 * @author chezhu.xin
 */
public interface ICore {
    /**
     * 宽度
     */
    int WIDTH = 30;
    /**
     * 高度
     */
    int HEIGHT = 6;
    /**
     * 元素列表
     */


    /**
     * 添加红色球
     */
    void red();

    /**
     * 添加蓝色球
     */
    void blue();

    /**
     * 撤销
     */
    void undo();

    ActionEnum getDirection(StatusEnum[][] array, int x, int y, StatusEnum next, ActionEnum preAction);

    StatusEnum[][] getStatusEnum();

    enum StatusEnum {
        BLANK("-", 0),
        RED("红", 1),
        BLUE("蓝", 2);
        private final String desc;
        private final int code;

        StatusEnum(String desc, int code) {
            this.desc = desc;
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public int getCode() {
            return code;
        }
    }

    enum ActionEnum {
        DOWN("向下", 0),
        RIGHT("向右", 1),
        NEW("另起一行", 2);
        private final String desc;
        private final int code;

        ActionEnum(String desc, int code) {
            this.desc = desc;
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public int getCode() {
            return code;
        }
    }
}
