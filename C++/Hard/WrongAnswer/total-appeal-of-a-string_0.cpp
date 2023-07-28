class Solution {
public:
    long long appealSum(string s) {
        
        int n = s.length();
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            int count[26] = {0};
            for (int j = i; j < n; j++) {
                if (count[s[j]-'a'] == 0) {
                    ans++;
                    count[s[j]-'a']++;
                }
            }
        }
        return ans;
    }
};