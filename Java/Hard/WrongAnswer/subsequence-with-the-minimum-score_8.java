class Solution {
    public int minimumScore(String s, String t) {
        
        int[] count = new int[26];
        int n = s.length();
        int m = t.length();
        for(int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < m; i++) {
            count[t.charAt(i) - 'a']--;
        }
        int left = 0;
        int right = n - 1;
        int res = 0;
        for(int i = 0; i < 26; i++) {
            if(count[i] > 0) {
                res += count[i];
            }
        }
        return res;
    }
}