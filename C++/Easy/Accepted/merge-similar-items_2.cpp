class Solution {
public:
    vector<vector<int>> mergeSimilarItems(vector<vector<int>>& items1, vector<vector<int>>& items2) {
        
        int n1 = items1.size();
        int n2 = items2.size();
        map<int, int> m1;
        map<int, int> m2;
        for (int i = 0; i < n1; i++) {
            m1[items1[i][0]] = items1[i][1];
        }
        for (int i = 0; i < n2; i++) {
            m2[items2[i][0]] = items2[i][1];
        }
        vector<vector<int>> ret;
        for (auto it = m1.begin(); it != m1.end(); it++) {
            int val = it->first;
            int w1 = it->second;
            int w2 = m2[val];
            ret.push_back({val, w1 + w2});
        }
        for (auto it = m2.begin(); it != m2.end(); it++) {
            int val = it->first;
            if (m1.find(val) == m1.end()) {
                ret.push_back({val, it->second});
            }
        }
        sort(ret.begin(), ret.end());
        return ret;
    }
};