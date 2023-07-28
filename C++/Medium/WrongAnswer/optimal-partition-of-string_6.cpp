class Solution {
public:
    int partitionString(string s) {
        
        int n = s.size();
        vector<int> last(26);
        for (int i = 0; i < n; ++i) {
            last[s[i] - 'a'] = i;
        }
        int ans = 1;
        int r = 0;
        for (int i = 0; i < n; ++i) {
            r = max(r, last[s[i] - 'a']);
            if (i == r) {
                ++ans;
            }
        }
        return ans - 1;
    }
};