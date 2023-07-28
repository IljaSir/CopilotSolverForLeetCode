class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        for (String s : strs) {
            int val = 0;
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
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