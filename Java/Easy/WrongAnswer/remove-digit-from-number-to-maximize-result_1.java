class Solution {
    public String removeDigit(String number, char digit) {
        
        StringBuilder sb = new StringBuilder();
        boolean removed = false;
        for (char c : number.toCharArray()) {
            if (c == digit && !removed) {
                removed = true;
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}