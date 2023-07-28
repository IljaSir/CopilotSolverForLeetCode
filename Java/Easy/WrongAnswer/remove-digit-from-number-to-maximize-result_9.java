class Solution {
    public String removeDigit(String number, char digit) {
        
        int i = 0;
        while(i < number.length() && number.charAt(i) != digit) {
            i++;
        }
        if(i == number.length()) {
            return number;
        }
        String s1 = number.substring(0, i);
        String s2 = number.substring(i+1);
        String s = s1 + s2;
        if(s.length() == 0) {
            return "0";
        }
        return s;
    }
}