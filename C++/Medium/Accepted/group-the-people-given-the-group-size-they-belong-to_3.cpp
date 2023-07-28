class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        
        vector<vector<int>> result;
        map<int, vector<int>> m;
        for (int i = 0; i < groupSizes.size(); i++) {
            m[groupSizes[i]].push_back(i);
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            vector<int> v = it->second;
            int size = it->first;
            for (int i = 0; i < v.size(); i += size) {
                result.push_back(vector<int>(v.begin() + i, v.begin() + i + size));
            }
        }
        return result;
    }
};