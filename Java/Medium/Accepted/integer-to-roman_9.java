class Solution {
    public String intToRoman(int num) {
        
        String result = "";
        if (num >= 1000) {
            int times = num / 1000;
            result += repeat("M", times);
            num = num % 1000;
        }
        if (num >= 100) {
            int times = num / 100;
            if (times == 4) {
                result += "CD";
            } else if (times == 9) {
                result += "CM";
            } else if (times >= 5) {
                result += "D";
                result += repeat("C", times - 5);
            } else {
                result += repeat("C", times);
            }
            num = num % 100;
        }
        if (num >= 10) {
            int times = num / 10;
            if (times == 4) {
                result += "XL";
            } else if (times == 9) {
                result += "XC";
            } else if (times >= 5) {
                result += "L";
                result += repeat("X", times - 5);
            } else {
                result += repeat("X", times);
            }
            num = num % 10;
        }
        if (num >= 1) {
            int times = num / 1;
            if (times == 4) {
                result += "IV";
            } else if (times == 9) {
                result += "IX";
            } else if (times >= 5) {
                result += "V";
                result += repeat("I", times - 5);
            } else {
                result += repeat("I", times);
            }
            num = num % 1;
        }
        return result;
    }
    private String repeat(String s, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += s;
        }
        return result;
    }
}