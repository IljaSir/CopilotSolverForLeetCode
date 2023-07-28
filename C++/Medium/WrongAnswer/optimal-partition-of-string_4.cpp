class Solution {
public:
    int partitionString(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        for (int i = 0; i < n; i++) {
            last[s[i] - 'a'] = i;
        }
        int ans = 0;
        int maxRight = 0;
        for (int i = 0; i < n; i++) {
            maxRight = max(maxRight, last[s[i] - 'a']);
            if (i == maxRight) {
                ans++;
            }
        }
        return ans;
    }
};