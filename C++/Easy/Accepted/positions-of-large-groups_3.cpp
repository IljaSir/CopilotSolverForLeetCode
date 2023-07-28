class Solution {
public:
    vector<vector<int>> largeGroupPositions(string s) {
        
        vector<vector<int>> ans;
        int i = 0;
        while(i < s.size()) {
            int j = i;
            while(j < s.size() && s[j] == s[i]) j++;
            if(j - i >= 3) ans.push_back({i, j - 1});
            i = j;
        }
        return ans;
    }
};