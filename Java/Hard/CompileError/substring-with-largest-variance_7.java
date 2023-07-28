class Solution {
    public int largestVariance(String s) {
        
        int[] count = new int[26];
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(count, 0);
            for (int j = i; j < n; j++) {
                count[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (count[k] > 0) {
                        min = Math.min(min, count[k]);
                        max = Math.max(max, count[k]);
                    }
                }
                max = Math.max(max, max - min);
            }
        }
        return max;
    }
}