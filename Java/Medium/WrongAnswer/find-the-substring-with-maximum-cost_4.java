class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
        int[] charMap = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charMap[chars.charAt(i) - 'a'] = vals[i];
        }
        int maxCost = 0;
        for (int i = 0; i < s.length(); i++) {
            int cost = 0;
            for (int j = i; j < s.length(); j++) {
                int charValue = charMap[s.charAt(j) - 'a'];
                if (charValue == 0) {
                    charValue = s.charAt(j) - 'a' + 1;
                }
                cost += charValue;
                maxCost = Math.max(maxCost, cost);
            }
        }
        return maxCost;
    }
}