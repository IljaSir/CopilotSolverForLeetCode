class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        
        if (k < 0) return 0;
        unordered_map<int, int> m;
        for (auto& n : nums) {
            m[n]++;
        }
        int res = 0;
        for (auto& [n, count] : m) {
            if (k == 0) {
                if (count > 1) res++;
            } else {
                if (m.count(n + k)) res++;
            }
        }
        return res;
    }
};