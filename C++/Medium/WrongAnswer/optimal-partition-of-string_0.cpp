class Solution {
public:
    int partitionString(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        for (int i = 0; i < n; ++i) {
            last[s[i] - 'a'] = i;
        }
        int ans = 0, start = 0, end = 0;
        for (int i = 0; i < n; ++i) {
            end = max(end, last[s[i] - 'a']);
            if (i == end) {
                ++ans;
                start = end + 1;
            }
        }
        return ans;
    }
};