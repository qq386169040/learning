package com.bszhang.java.learn.basic.enums;

enum ColorEnum {
    RED("red", "红色"),
    BLUE("blue", "蓝色"),
    GREEN("green", "绿色");

    private final String key;
    private final String value;

    ColorEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static ColorEnum getEnumByKey(String key) {
        if (null == key) {
            return null;
        }

        for (ColorEnum tmp : ColorEnum.values()) {
            if (tmp.getKey().equals(key)) {
                return tmp;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        ColorEnum red = ColorEnum.getEnumByKey("red");
        System.out.println(red.getKey());
        System.out.println(red.getValue());

        ColorEnum blue = ColorEnum.BLUE;
    }
}