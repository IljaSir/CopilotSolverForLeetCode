class Solution {
public:
    int countAnagrams(string s) {
        
        int n = s.size();
        int mod = 1e9 + 7;
        vector<int> f(26, 0);
        for (char c : s) {
            if (c != ' ') {
                f[c - 'a']++;
            }
        }
        long long ans = 1;
        for (int i = 0; i < 26; i++) {
            ans = ans * f[i] % mod;
        }
        return ans;
    }
};