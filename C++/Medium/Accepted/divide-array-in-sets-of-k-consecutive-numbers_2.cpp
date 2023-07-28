class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        
        if (nums.size() % k != 0) return false;
        map<int, int> m;
        for (auto n : nums) {
            m[n]++;
        }
        while (m.size() > 0) {
            int key = m.begin()->first;
            int count = m.begin()->second;
            for (int i = 0; i < k; i++) {
                if (m.find(key + i) == m.end() || m[key + i] < count) {
                    return false;
                }
                m[key + i] -= count;
                if (m[key + i] == 0) {
                    m.erase(key + i);
                }
            }
        }
        return true;
    }
};