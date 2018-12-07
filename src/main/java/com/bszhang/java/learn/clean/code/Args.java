package com.bszhang.java.learn.clean.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Args {
    private String schema;
    private String[] args;

    private Map<Character, Boolean> booleanMap = new HashMap<Character, Boolean>();
    private Set<Character> flagSet = new HashSet<Character>();

    public Args(String schema, String[] args) {
        this.schema = schema;
        this.args = args;
        parse();
    }

    private void parse() {
        initFlagSet();
        parseArgs();
    }

    private void parseArgs() {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (!arg.startsWith("-")) {
                throw new RuntimeException("格式错误，每个参数需要以-<flag>开始");
            }

            arg = arg.substring(1);
            for (int j = 0; j < arg.length(); j++) {
                booleanMap.put(arg.charAt(j), true);
            }

            if ((i < args.length -1) && !args[i + 1].startsWith("-")) {
                i++;
            }
        }
    }

    private void initFlagSet() {
        String[] flagArray = schema.split(",");
        for (String flag : flagArray) {
            flagSet.add(flag.charAt(0));
        }
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
        assert (!arg.getBoolean('u'));
    }
}
