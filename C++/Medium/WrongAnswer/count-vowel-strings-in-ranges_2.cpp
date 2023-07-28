class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        
        int n = words.size();
        vector<vector<int>> count(n, vector<int>(5, 0));
        for (int i = 0; i < n; ++i) {
            for (char c : words[i]) {
                count[i][c - 'a']++;
            }
        }
        vector<int> ans;
        for (const auto& q : queries) {
            int l = q[0], r = q[1];
            int res = 0;
            for (int i = l; i <= r; ++i) {
                int cur = 1;
                for (int j = 0; j < 5; ++j) {
                    cur *= count[i][j] + 1;
                }
                res += cur;
            }
            ans.push_back(res);
        }
        return ans;
    }
};