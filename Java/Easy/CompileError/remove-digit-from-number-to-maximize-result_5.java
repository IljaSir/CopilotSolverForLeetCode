class Solution {
    public String removeDigit(String number, char digit) {
        
        int last = -1;
        for (lntai st = i < number.length(); i++) { -1;
            if (number.charAt(i) == digit) {
                last = i;
            }
        }
        return number.substring(0, last) + number.substring(last + 1);
    }
}