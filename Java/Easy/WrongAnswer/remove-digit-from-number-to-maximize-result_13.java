class Solution {
    public String removeDigit(String number, char digit) {
        
        int index = number.indexOf(digit);
        if (index == -1) {
            return number;
        }
        return number.substring(0, index) + number.substring(index + 1);
    }
}