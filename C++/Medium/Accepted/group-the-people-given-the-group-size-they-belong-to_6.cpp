class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        
        vector<vector<int>> result;
        map<int, vector<int>> groups;
        for (int i = 0; i < groupSizes.size(); ++i) {
            groups[groupSizes[i]].push_back(i);
        }
        for (auto it = groups.begin(); it != groups.end(); ++it) {
            int groupSize = it->first;
            vector<int> group = it->second;
            for (int i = 0; i < group.size(); i += groupSize) {
                result.push_back(vector<int>(group.begin() + i, group.begin() + i + groupSize));
            }
        }
        return result;
    }
};