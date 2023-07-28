class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        
        int n = groupSizes.size();
        vector<vector<int>> res;
        vector<int> temp;
        unordered_map<int,vector<int>> m;
        for(int i=0;i<n;i++){
            m[groupSizes[i]].push_back(i);
            if(m[groupSizes[i]].size()==groupSizes[i]){
                res.push_back(m[groupSizes[i]]);
                m[groupSizes[i]].clear();
            }
        }
        return res;
    }
};