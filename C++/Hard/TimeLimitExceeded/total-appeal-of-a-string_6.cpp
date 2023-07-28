class Solution {
public:
    long long appealSum(string s) {
        
        long long n = s.size();
        long long ans = 0;
        long long cnt[26] = {0};
        for (long long i = 0; i < n; i++) {
            long long sum = 0;
            memset(cnt, 0, sizeof(cnt));
            for (long long j = i; j < n; j++) {
                if (cnt[s[j] - 'a'] == 0) {
                    sum++;
                }
                cnt[s[j] - 'a']++;
                ans += sum;
            }
        }
        return ans;
    }
};