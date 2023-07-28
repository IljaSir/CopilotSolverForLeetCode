class Solution {
public:
    vector<vector<int>> validArrangement(vector<vector<int>>& pairs) {
        
        vector<vector<int>> res;
        sort(pairs.begin(), pairs.end(), [](auto a, auto b){return a[1] < b[1];});
        res.push_back(pairs[0]);
        for(int i = 1; i < pairs.size(); i++){
            if(res.back()[1] == pairs[i][0]){
                res.push_back(pairs[i]);
            }
        }
        return res;
    }
};