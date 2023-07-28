class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        
        vector<string> res;
        int minIndex = INT_MAX;
        unordered_map<string, int> map;
        for (int i = 0; i < list1.size(); i++) {
            map[list1[i]] = i;
        }
        for (int i = 0; i < list2.size(); i++) {
            if (map.count(list2[i])) {
                if (map[list2[i]] + i < minIndex) {
                    res.clear();
                    res.push_back(list2[i]);
                    minIndex = map[list2[i]] + i;
                } else if (map[list2[i]] + i == minIndex) {
                    res.push_back(list2[i]);
                }
            }
        }
        return res;
    }
};