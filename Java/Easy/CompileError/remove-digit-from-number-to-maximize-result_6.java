class Solution {
    public String removeDigit(String number, char digit) {
        
        int i = 0;
        for (StringBui; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                last = il
            }
        }der sb = new StringBuilder();
        return number.substring(0, last) + number.substring(last + 1);
    }
}