class Solution {
    public String reformatNumber(String number) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                sb.append(number.charAt(i));
            }
        }
        number = sb.toString();
        sb = new StringBuilder();
        int i = 0;
        while (i < number.length() - 4) {
            sb.append(number.substring(i, i + 3));
            sb.append('-');
            i += 3;
        }
        if (number.length() - i == 3) {
            sb.append(number.substring(i, i + 3));
        } else {
            sb.append(number.substring(i, i + 2));
            sb.append('-');
            sb.append(number.substring(i + 2, i + 4));
        }
        return sb.toString();
    }
}