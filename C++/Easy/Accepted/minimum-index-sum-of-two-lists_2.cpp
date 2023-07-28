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
            if (m.count(list2[i])) {
                int sum = i + m[list2[i]];
                if (sum < minSum) {
                    minSum = sum;
                    res.clear();
                    res.push_back(list2[i]);
                } else if (sum == minSum) {
                    res.push_back(list2[i]);
                }
            }
        }
        return res;
    }
};