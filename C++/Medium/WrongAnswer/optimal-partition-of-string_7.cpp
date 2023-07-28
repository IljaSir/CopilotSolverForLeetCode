class Solution {
public:
    int partitionString(string s) {
        
        int n = s.length();
        vector<int> last(26);
        for (int i = 0; i < n; i++) {
            last[s[i] - 'a'] = i;
        }
        int ans = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            end = max(end, last[s[i] - 'a']);
            if (i == end) {
                ans++;
                start = end + 1;
            }
        }
        return ans;
    }
};