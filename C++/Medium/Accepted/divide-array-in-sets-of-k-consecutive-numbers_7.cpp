class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        
        map<int, int> m;
        for (auto x : nums) m[x]++;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second > 0) {
                for (int i = 1; i < k; i++) {
                    if (m.find(it->first + i) == m.end() || m[it->first + i] < it->second) return false;
                    m[it->first + i] -= it->second;
                }
            }
        }
        return true;
    }
};