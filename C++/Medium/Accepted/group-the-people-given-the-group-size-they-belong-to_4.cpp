class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        
        vector<vector<int>> result;
        unordered_map<int, vector<int>> map;
        for (int i = 0; i < groupSizes.size(); i++) {
            map[groupSizes[i]].push_back(i);
        }
        for (auto it = map.begin(); it != map.end(); it++) {
            int size = it->first;
            vector<int> list = it->second;
            vector<int> temp;
            for (int i = 0; i < list.size(); i++) {
                temp.push_back(list[i]);
                if (temp.size() == size) {
                    result.push_back(temp);
                    temp.clear();
                }
            }
        }
        return result;
    }
};