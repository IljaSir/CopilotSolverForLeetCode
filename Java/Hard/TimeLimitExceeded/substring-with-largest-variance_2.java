class Solution {
    public int largestVariance(String s) {
        
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (count[k] > 0) {
                        min = Math.min(min, count[k]);
                        max = Math.max(max, count[k]);
                    }
                }
                res = Math.max(res, max - min);
            }
        }
        return res;
    }
}