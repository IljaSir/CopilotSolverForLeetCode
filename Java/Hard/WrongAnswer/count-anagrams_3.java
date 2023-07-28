class Solution {
    public int countAnagrams(String s) {
        
        int mod = 1000000007;
        int[] fact = new int[100001];
        fact[0] = 1;
        for(int i = 1; i <= 100000; i++) {
            fact[i] = (int)(((long)fact[i-1] * (long)i) % mod);
        }
        int n = s.length();
        int[] cnt = new int[26];
        int ans = 1;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ') {
                int ncnt = 0;
                for(int j = 0; j < 26; j++) {
                    ncnt += cnt[j];
                    cnt[j] = 0;
                }
                ans = (int)(((long)ans * (long)fact[ncnt]) % mod);
            } else {
                cnt[s.charAt(i)-'a']++;
            }
        }
        int ncnt = 0;
        for(int j = 0; j < 26; j++) {
            ncnt += cnt[j];
            cnt[j] = 0;
        }
        ans = (int)(((long)ans * (long)fact[ncnt]) % mod);
        return ans;
    }
}