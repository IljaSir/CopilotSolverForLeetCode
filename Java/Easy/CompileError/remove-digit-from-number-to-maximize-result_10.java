class Solution {
    public String removeDigit(String number, char digit) {
        
        int n = number.length();
        int i = 0;
        while(i < n && number.charAt(i) != digit) i++;
        if(i == n) return number;
        StringBuilder sb = new StringBuilder(number);
        sb.deleteCharAt(i);
        return sb.toString();
    }
    public String removeDigit2(String number, char digit) {
        int n = number.length();
        int i = 0;
        while(i < n && number.charAt(i) != digit) i++;
        if(i == n) return number;
        return number.substring(0, i) + number.substring(i+1);
    }
    public String removeDigit3(String number, char digit) {
        int n = number.length();
        int i = 0;
        while(i < n && number.charAt(i) != digit) i++;
        if(i == n) return number;
        return number.replace(digit+"", "");
    }
    public String removeDigit4(String number, char digit) {
        int n = number.length();
        int i = 0;
        while(i < n && number.charAt(i) != digit) i++;
        if(i == n) return number;
        return number.replaceAll(digit+"", "");
    }
    public String removeDigit5(String number, char digit) {
        int n = number.length();
        int i = 0;
        while(i < n && number.charAt(i) != digit) i++;
        if(i == n) return number;
        return number.replaceAll(digit+"", "");
    }
    public String removeDigit6(String number, char digit) {
        int n = number.length();
        int i = 0;
        while(i < n && number.charAt(i) != digit) i++;
        if(i == n) return number;
        return number.replaceFirst(digit+"", "");
    }
    public String removeDigit7(String number, char digit) {
        int n = number.length();
        int i = 0;
        while(i < n && number.charAt(i) != digit) i++;
        if(i == n) return number;
        return number.replaceFirst(digit+"", ""
            }
            i++;
        }
        return number;
    }
    public String removeDigit6(String number, char digit) {
        int i = 0;
        while (i < number.length()) {
            if (number.charAt(i) == digit) {
                number = number.substring(0, i) + number.substring(i+1);
    }
}