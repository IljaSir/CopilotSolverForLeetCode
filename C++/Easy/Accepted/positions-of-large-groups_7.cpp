class Solution {
public:
    vector<vector<int>> largeGroupPositions(string s) {
        
        vector<vector<int>> ans;
        int l = s.length();
        int i = 0;
        while (i < l) {
            int j = i;
            while (j < l && s[j] == s[i]) {
                j++;
            }
            if (j - i >= 3) {
                ans.push_back({i, j - 1});
            }
            i = j;
        }
        return ans;
    }
};