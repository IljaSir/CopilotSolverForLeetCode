class Solution {
    public String removeDigit(String number, char digit) {
        
        int i = 0;
        int i = 0;
        while (i < number.length() && number.charAt(i) != digit) {
            sb.append(number.charAt(i));
            i++;
        }
        i++;
        while (i < number.length()) {
            if (number.charAt(i) != digit) {
                sb.append(number.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}