class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        
        map<string, int> m;
        for (int i = 0; i < list1.size(); i++) {
            m[list1[i]] = i;
        }
        vector<string> res;
        int minSum = INT_MAX;
        for (int i = 0; i < list2.size(); i++) {
            auto it = m.find(list2[i]);
            if (it != m.end()) {
                int sum = it->second + i;
                if (minSum > sum) {
                    minSum = sum;
                    res.clear();
                    res.push_back(list2[i]);
                } else if (minSum == sum) {
                    res.push_back(list2[i]);
                }
            }
        }
        return res;
    }
};