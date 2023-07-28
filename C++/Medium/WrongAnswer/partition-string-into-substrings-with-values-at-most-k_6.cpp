class Solution {
public:
    int minimumPartition(string s, int k) {
        
        int n = s.size();
        int ans = 1;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur = max(cur, s[i] - '0');
            if (cur > k) {
                ans++;
                cur = s[i] - '0';
            }
        }
        return ans;
    }
};