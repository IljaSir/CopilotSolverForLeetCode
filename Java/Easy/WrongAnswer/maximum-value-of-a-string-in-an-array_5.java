class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        for (String str : strs) {
            int val = 0;
            for (char c : str.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    val = val * 10 + (c - '0');
                } else {
                    val++;
                }
            }
            max = Math.max(max, val);
        }
        return max;
    }
}