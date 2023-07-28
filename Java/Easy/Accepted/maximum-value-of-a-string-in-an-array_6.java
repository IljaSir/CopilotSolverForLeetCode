class Solution {
    public int maximumValue(String[] strs) {
        
        int max = 0;
        for (String str: strs) {
            int val = 0;
            try {
                val = Integer.parseInt(str);
            } catch (Exception e) {
                val = str.length();
            }
            max = Math.max(max, val);
        }
        return max;
    }
}