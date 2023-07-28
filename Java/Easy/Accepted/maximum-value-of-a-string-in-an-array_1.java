class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        for (String str : strs) {
            int val = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    val *= 10;
                    val += c - '0';
                } else {
                    val = str.length();
                    break;
                }
            }
            max = Math.max(max, val);
        }
        return max;
    }
}