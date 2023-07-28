class Solution {
public:
    vector<vector<int>> largeGroupPositions(string s) {
        
        vector<vector<int>> result;
        int i = 0;
        while(i < s.size()) {
            int j = i;
            while(j < s.size() && s[i] == s[j]) {
                j++;
            }
            if(j - i >= 3) {
                result.push_back({i, j - 1});
            }
            i = j;
        }
        return result;
    }
};