class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
        int[] charValues = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charValues[chars.charAt(i) - 'a'] = vals[i];
        } - i + 1);
        }
        return res;
    }
}