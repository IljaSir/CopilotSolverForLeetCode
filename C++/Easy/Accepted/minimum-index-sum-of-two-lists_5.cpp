class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        
        unordered_map<string, int> index;
        for (int i = 0; i < list1.size(); i++) {
            index[list1[i]] = i;
        }
        vector<string> res;
        int minSum = INT_MAX;
        for (int i = 0; i < list2.size(); i++) {
            if (index.count(list2[i])) {
                if (minSum > i + index[list2[i]]) {
                    res.clear();
                    res.push_back(list2[i]);
                    minSum = i + index[list2[i]];
                } else if (minSum == i + index[list2[i]]) {
                    res.push_back(list2[i]);
                }
            }
        }
        return res;
    }
};