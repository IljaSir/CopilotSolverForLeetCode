class Solution {
public:
    int partitionString(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        for (int i = 0; i < n; ++i) {
            last[s[i] - 'a'] = i;
        }
        int res = 0;
        int l = 0, r = 0;
        for (int i = 0; i < n; ++i) {
            r = max(r, last[s[i] - 'a']);
            if (i == r) {
                ++res;
                l = i + 1;
            }
        }
        return res;
    }
};