class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        
        int n = groupSizes.size();
        vector<vector<int>> result;
        vector<vector<int>> group(n+1);
        for (int i = 0; i < n; ++i) {
            group[groupSizes[i]].push_back(i);
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < group[i].size(); j += i) {
                result.push_back(vector<int>(group[i].begin()+j, group[i].begin()+j+i));
            }
        }
        return result;
    }
};