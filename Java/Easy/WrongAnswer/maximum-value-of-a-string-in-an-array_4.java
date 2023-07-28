class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        for (String s : strs) {
            int value = 0;
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    value = value * 10 + (c - '0');
                } else {
                    value++;
                }
            }
            max = Math.max(max, value);
        }
        return max;
    }
}