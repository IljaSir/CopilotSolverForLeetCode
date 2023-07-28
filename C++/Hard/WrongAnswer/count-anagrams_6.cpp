class Solution {
public:
    int countAnagrams(string s) {
        
        int n = s.size();
        vector<int> fact(n + 1);
        fact[0] = 1;
        for(int i = 1; i <= n; i++) fact[i] = (i * 1LL * fact[i - 1]) % 1000000007;
        vector<int> cnt(26);
        int ans = 1;
        for(int i = 0; i < n; i++) {
            if(s[i] == ' ') {
                int curr = 0;
                for(int j = 0; j < 26; j++) curr += cnt[j] > 0;
                ans = (ans * 1LL * fact[curr]) % 1000000007;
                for(int j = 0; j < 26; j++) cnt[j] = 0;
            } else {
                cnt[s[i] - 'a']++;
            }
        }
        int curr = 0;
        for(int j = 0; j < 26; j++) curr += cnt[j] > 0;
        ans = (ans * 1LL * fact[curr]) % 1000000007;
        return ans;
    }
};