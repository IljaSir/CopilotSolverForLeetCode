class Solution {
public:
    int maximumCostSubstring(string s, string chars, vector<int>& vals) {
        
        int n = s.size();
        int m = chars.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                char ch = s[j];
                int k = 0;
                for (; k < m; k++) {
                    if (chars[k] == ch)
                        break;
                }
                if (k == m) {
                    sum += ch - 'a' + 1;
                } else {
                    sum += vals[k];
                }
                ans = max(ans, sum);
            }
        }
        return ans;
    }
};