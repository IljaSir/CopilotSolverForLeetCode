class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        for (String s : strs) {
            int val = 0;
            try {
                val = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                val = s.length();
            }
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
}