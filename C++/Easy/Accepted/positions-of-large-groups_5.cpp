class Solution {
public:
    vector<vector<int>> largeGroupPositions(string s) {
        
        vector<vector<int>> res;
        int len = s.size();
        for (int i = 0; i < len; i++) {
            int j = i;
            while (j < len && s[i] == s[j]) j++;
            if (j - i >= 3) res.push_back({i, j - 1});
            i = j - 1;
        }
        return res;
    }
};