class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        
        if (nums.size() % k != 0) return false;
        map<int, int> m;
        for (auto x: nums) m[x]++;
        for (auto &x: m) {
            int y = x.second;
            if (y == 0) continue;
            for (int i = 0; i < k; i++) {
                if (m[x.first + i] < y) return false;
                m[x.first + i] -= y;
            }
        }
        return true;
    }
};