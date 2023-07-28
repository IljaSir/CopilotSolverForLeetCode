class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        
        vector<int> res;
        map<int, int> m;
        for (auto& x : arr) {
            m[x] = 0;
        }
        int rank = 1;
        for (auto& x : m) {
            m[x.first] = rank++;
        }
        for (auto& x : arr) {
            res.push_back(m[x]);
        }
        return res;
    }
};