class Solution {
public:
    vector<vector<int>> largeGroupPositions(string s) {
        
        vector<vector<int>> res;
        int i = 0;
        while(i < s.size()){
            int j = i + 1;
            while(j < s.size() && s[j] == s[i]) ++j;
            if(j - i >= 3){
                res.push_back({i, j - 1});
            }
            i = j;
        }
        return res;
    }
};