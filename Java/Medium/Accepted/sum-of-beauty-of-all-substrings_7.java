class Solution {
    public int beautySum(String s) {
        
        int n = s.length();
        int res = 0;
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            Arrays.fill(freq, 0);
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                int max = 0;
                int min = 500;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] == 0) continue;
                    max = Math.max(max, freq[k]);
                    min = Math.min(min, freq[k]);
                }
                res += max - min;
            }
        }
        return res;
    }
}