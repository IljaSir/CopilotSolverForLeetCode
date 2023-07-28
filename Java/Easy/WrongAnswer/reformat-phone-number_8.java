class Solution {
    public String reformatNumber(String number) {
        
        number = number.replaceAll("[^0-9]", "");
        int n = number.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0 && (i % 3 == 0 || (i + 4 == n || i + 2 == n))) {
                sb.append('-');
            }
            sb.append(number.charAt(i));
        }
        return sb.toString();
    }
}