class Solution {
    public String reformatNumber(String number) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                sb.append(number.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < sb.length()) {
            if (sb.length() - i <= 4) {
                if (sb.length() - i == 2) {
                    result.append(sb.charAt(i));
                    result.append(sb.charAt(i + 1));
                } else if (sb.length() - i == 3) {
                    result.append(sb.charAt(i));
                    result.append(sb.charAt(i + 1));
                    result.append(sb.charAt(i + 2));
                } else if (sb.length() - i == 4) {
                    result.append(sb.charAt(i));
                    result.append(sb.charAt(i + 1));
                    result.append('-');
                    result.append(sb.charAt(i + 2));
                    result.append(sb.charAt(i + 3));
                }
                break;
            } else {
                result.append(sb.charAt(i));
                result.append(sb.charAt(i + 1));
                result.append(sb.charAt(i + 2));
                result.append('-');
                i += 3;
            }
        }
        return result.toString();
    }
}