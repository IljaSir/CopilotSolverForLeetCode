class Solution {
    public int largestVariance(String s) {
        
        int[] counts = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(counts, 0);
            int min = Integer.MAX_VALUE;
            int maxCount = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                counts[c - 'a']++;
                maxCount = Math.max(maxCount, counts[c - 'a']);
                min = Math.min(min, maxCount);
                max = Math.max(max, maxCount - min);
            }
        }
        return max;
    }
}