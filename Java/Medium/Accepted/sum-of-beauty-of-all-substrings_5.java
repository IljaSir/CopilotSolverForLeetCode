class Solution {
    public int beautySum(String s) {
        
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            for (int j = i; j < n; j++) {
                cnt[s.charAt(j) - 'a']++;
                int max = 0, min = 500;
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] != 0) {
                        max = Math.max(max, cnt[k]);
                        min = Math.min(min, cnt[k]);
                    }
                }
                sum += max - min;
            }
        }
        return sum;
    }
}