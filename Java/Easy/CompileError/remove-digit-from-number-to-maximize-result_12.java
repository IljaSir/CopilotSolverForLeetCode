class Solution {
    public String removeDigit(String number, char digit) {
        
        int i = 0;
        while (i < number.length() && number.charAt(i) != digit) {
            i++;
        }
        if (i == number.length()) {
            return number;
        }
        return number.substring(0, i) + number.substring(i + 1);
    }
    public String removeDigit1(String number, char digit) {
        int i = 0;
        while (i < number.length() && number.charAt(i) != digit) {
            i++;
        }
        if (i == number.length()) {
            return number;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(number.charAt(j));
        }
        for (int j = i + 1; j < number.length(); j++) {
            sb.append(number.charAt(j));
        }
        return sb.toString();
    }
    public String removeDigit2(String number, char digit) {
        int i = 0;
        while (i < number.length() && number.charAt(i) != digit) {
            i++;
        }
        if (i == number.length()) {
            return number;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(number.charAt(j));
        }
        for (int j = i + 1; j < number.length(); j++) {
            sb.append(number.charAt(j));
        }
        return sb.toString();
    }
    public String removeDigit3(String number, char digit) {
        int i = 0;
        while (i < number.length() && number.charAt(i) != digit) {
            i++;
        }
        if (i == number.length()) {
            return number;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(number.charAt(j));
        }
        for (int j = i + 1; j < number.length(); j++) {
            sb.append(number.charAt(j));
        }
        return sb.toString();
    }
    public String removeDigit4(String number, char digit) {
        int i = 0;
        while (i < number.length() && number.charAt(i) != digit) {
            i++;
        }
        if (i == number.length()) {
            return number;
        }
        StringBuilder sb = new StringBuilder();
    }
}