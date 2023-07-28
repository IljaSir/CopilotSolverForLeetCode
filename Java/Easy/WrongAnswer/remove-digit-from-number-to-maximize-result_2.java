class Solution {
    public String removeDigit(String number, char digit) {
        
        StringBuilder sb = new StringBuilder();
        boolean removed = false;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c == digit && !removed) {
                removed = true;
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}