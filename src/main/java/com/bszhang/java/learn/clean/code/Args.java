package com.bszhang.java.learn.clean.code;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private String schema;
    private String[] args;

    private Map<Character, Boolean> booleanMap = new HashMap<Character, Boolean>();

    public Args(String schema, String args[]) {
        this.schema = schema;
        this.args = args;
        parse();
    }

    private void parse() {

    }

    public boolean getBoolean(char arg) {
        return booleanMap.get(arg) != null;
    }

    public static void main(String[] args) {
        String[] array = {"-l", "-d"};
        String schema = "l,d,u";

        Args arg = new Args(schema, array);

        assert (arg.getBoolean('l'));
        assert (arg.getBoolean('d'));
        assert (arg.getBoolean('u') == false);
    }
}
