class Solution {
    public String removeDigit(String number, char digit) {
        
        StringBuilder sb = new StringBuilder();
        boolean removed = false;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit && !removed) {
                removed = true;
            } else {
                sb.append(number.charAt(i));
            }
        }
        return sb.toString();
    }
}