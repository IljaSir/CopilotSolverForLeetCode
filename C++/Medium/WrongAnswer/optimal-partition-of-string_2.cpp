class Solution {
public:
    int partitionString(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        for (int i = 0; i < n; i++) {
            last[s[i] - 'a'] = i;
        }
        int ans = 0, start = 0;
        for (int i = 0; i < n; i++) {
            start = max(start, last[s[i] - 'a']);
            if (i == start) {
                ans++;
            }
        }
        return ans;
    }
};