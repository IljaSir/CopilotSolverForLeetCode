class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        
        vector<string> res;
        unordered_map<string, int> m;
        int minSum = INT_MAX;
        for (int i = 0; i < list1.size(); i++) {
            m[list1[i]] = i;
        }
        for (int i = 0; i < list2.size(); i++) {
            if (m.find(list2[i]) != m.end()) {
                if (m[list2[i]] + i < minSum) {
                    res.clear();
                    res.push_back(list2[i]);
                    minSum = m[list2[i]] + i;
                } else if (m[list2[i]] + i == minSum) {
                    res.push_back(list2[i]);
                }
            }
        }
        return res;
    }
};