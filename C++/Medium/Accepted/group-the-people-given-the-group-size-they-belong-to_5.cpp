class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        
        vector<vector<int>> result;
        map<int, vector<int>> m;
        for (int i = 0; i < groupSizes.size(); ++i) {
            m[groupSizes[i]].push_back(i);
            if (m[groupSizes[i]].size() == groupSizes[i]) {
                result.push_back(m[groupSizes[i]]);
                m[groupSizes[i]].clear();
            }
        }
        return result;
    }
};