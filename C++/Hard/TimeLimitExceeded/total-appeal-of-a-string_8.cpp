class Solution {
public:
    long long appealSum(string s) {
        
        int n = s.length();
        int i = 0;
        long long ans = 0;
        while (i < n) {
            int j = i;
            int cnt = 0;
            bitset<26> bs;
            while (j < n) {
                if (!bs[s[j] - 'a']) {
                    bs[s[j] - 'a'] = 1;
                    cnt++;
                }
                ans += cnt;
                j++;
            }
            i++;
        }
        return ans;
    }
};