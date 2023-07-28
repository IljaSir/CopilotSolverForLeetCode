class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        for (String s : strs) {
            int val = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - '0';
                if (c >= 0 && c <= 9) {
                    val *= 10;
                    val += c;
                } else {
                    val = s.length();
                    break;
                }
            }
            max = Math.max(max, val);
        }
        return max;
    }
}