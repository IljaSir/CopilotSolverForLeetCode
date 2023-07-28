class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        
        map<int, int> m;
        for (auto& x : arr) {
            m[x]++;
        }
        for (auto& x : m) {
            if (x.first < 0) {
                if (x.second > m[x.first / 2]) {
                    return false;
                }
                m[x.first / 2] -= x.second;
            } else {
                if (x.second > m[2 * x.first]) {
                    return false;
                }
                m[2 * x.first] -= x.second;
            }
        }
        return true;
    }
};