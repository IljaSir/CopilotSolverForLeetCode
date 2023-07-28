class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        
        map<int, int> m;
        for (int i = 0; i < arr.size(); ++i) {
            ++m[arr[i]];
        }
        for (auto &p : m) {
            if (p.second > 0) {
                if (p.first < 0) {
                    if (m[p.first / 2] < p.second || p.first % 2 != 0) {
                        return false;
                    }
                } else {
                    if (m[p.first * 2] < p.second) {
                        return false;
                    }
                }
                m[p.first * 2] -= p.second;
            }
        }
        return true;
    }
};