class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        
        if (nums.size() % k != 0) return false;
        map<int, int> m;
        for (auto n : nums) m[n]++;
        while (!m.empty()) {
            auto it = m.begin();
            int x = it->first;
            for (int i = 0; i < k; i++) {
                if (m.find(x + i) == m.end()) return false;
                if (--m[x + i] == 0) m.erase(x + i);
            }
        }
        return true;
    }
};