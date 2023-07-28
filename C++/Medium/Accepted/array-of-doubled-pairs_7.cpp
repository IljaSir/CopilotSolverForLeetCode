class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        
        map<int, int> count;
        for (auto &a : arr) count[a]++;
        for (auto &p : count) {
            if (p.second > 0) {
                if (p.first < 0) {
                    if (p.first % 2 != 0) return false;
                    if (count[p.first / 2] < p.second) return false;
                    count[p.first / 2] -= p.second;
                } else {
                    if (count[2 * p.first] < p.second) return false;
                    count[2 * p.first] -= p.second;
                }
            }
        }
        return true;
    }
};