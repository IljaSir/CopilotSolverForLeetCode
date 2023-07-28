class Solution {
    public int beautySum(String s) {
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] counts = new int[26];
            for (int j = i; j < s.length(); j++) {
                counts[s.charAt(j) - 'a']++;
                int max = 0, min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (counts[k] > 0) {
                        max = Math.max(max, counts[k]);
                        min = Math.min(min, counts[k]);
                    }
                }
                sum += max - min;
            }
        }
        return sum;
    }
}