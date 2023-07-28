class Solution {
public:
    int maximumCostSubstring(string s, string chars, vector<int>& vals) {
        
        int n = s.length();
        int m = chars.length();
        vector<int> charMap(26, -1);
        for (int i = 0; i < m; ++i) {
            charMap[chars[i] - 'a'] = i;
        }
        vector<int> valMap(n, 0);
        for (int i = 0; i < n; ++i) {
            valMap[i] = charMap[s[i] - 'a'] == -1 ? s[i] - 'a' + 1 : vals[charMap[s[i] - 'a']];
        }
        int ans = 0;
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            sum += valMap[i];
            while (sum < 0) {
                sum -= valMap[idx++];
            }
            ans = max(ans, sum);
        }
        return ans;
    }
};