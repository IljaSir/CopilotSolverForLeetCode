class Solution {
    public int largestVariance(String s) {
        
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int c : count) {
                    if (c > 0) {
                        min = Math.min(min, c);
                        max = Math.max(max, c);
                    }
                }
                max = Math.max(max, max - min);
            }
        }
        return max;
    }
}