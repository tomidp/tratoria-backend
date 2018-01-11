package com.dp.tratoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestForEach {

    public static void main(String[] args) {

        List<Test> tests = new ArrayList<>();
        tests.add(new Test("1", "1"));
        tests.add(new Test("2", "2"));
        tests.add(new Test("3", "3"));
        tests.add(new Test("4", "4"));
        tests.add(new Test("1", "1"));
        tests.add(new Test("2", "2"));
        tests.add(new Test("3", "3"));
        tests.add(new Test("4", "4"));
        tests.add(new Test("1", "1"));
        tests.add(new Test("2", "2"));
        tests.add(new Test("3", "3"));
        tests.add(new Test("4", "4"));
        tests.add(new Test("1", "1"));
        tests.add(new Test("2", "2"));
        tests.add(new Test("3", "3"));
        tests.add(new Test("4", "4"));
        tests.add(new Test("1", "1"));
        tests.add(new Test("2", "2"));
        tests.add(new Test("3", "3"));
        tests.add(new Test("4", "4"));
        tests.add(new Test("1", "1"));
        tests.add(new Test("2", "2"));
        tests.add(new Test("3", "3"));
        tests.add(new Test("4", "4"));
        tests.add(new Test("1", "1"));
        tests.add(new Test("2", "2"));
        tests.add(new Test("3", "3"));
        tests.add(new Test("4", "4"));
        tests.add(new Test("1", "1"));
        tests.add(new Test("2", "2"));
        tests.add(new Test("3", "3"));
        tests.add(new Test("4", "4"));

        System.out.println("List size : " + tests.size());
        long startMapping = System.currentTimeMillis();
        Map<String, Test> testMap = new HashMap<String, Test>();
        tests.forEach(test -> {
            testMap.put(test.getCode(), test);
        });
        long endMapping = System.currentTimeMillis();
        long timeSpent = endMapping - startMapping;
        System.out.println("Time Spent :" + timeSpent);

        testMap.forEach((k,v) -> {
            System.out.println("code : " + k + "name : " + v.getName());
        });
    }

    private static class Test {
        String code;
        String name;

        public Test() {
        }

        public Test(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Test{");
            sb.append("code='").append(code).append('\'');
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
