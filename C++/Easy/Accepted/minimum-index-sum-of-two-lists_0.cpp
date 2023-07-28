class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        
        map<string, int> m1;
        map<string, int> m2;
        for (int i = 0; i < list1.size(); i++) {
            m1[list1[i]] = i;
        }
        for (int i = 0; i < list2.size(); i++) {
            m2[list2[i]] = i;
        }
        vector<string> ret;
        int minIdx = INT_MAX;
        for (auto it = m1.begin(); it != m1.end(); it++) {
            if (m2.find(it->first) != m2.end()) {
                int idx = it->second + m2[it->first];
                if (idx < minIdx) {
                    ret.clear();
                    ret.push_back(it->first);
                    minIdx = idx;
                } else if (idx == minIdx) {
                    ret.push_back(it->first);
                }
            }
        }
        return ret;
    }
};