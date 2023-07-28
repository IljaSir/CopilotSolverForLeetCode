class Solution {
public:
    long long countPairs(vector<int>& nums, int k) {
        
        map<int, int> m;
        for (auto n : nums) {
            m[n]++;
        }
        long long res = 0;
        for (auto it = m.begin(); it != m.end(); ++it) {
            if (k == 1) {
                res += (long long)it->second * (it->second - 1) / 2;
            } else {
                auto it2 = m.find(k - it->first);
                if (it2 != m.end()) {
                    res += (long long)it->second * it2->second;
                }
            }
        }
        return res;
    }
};