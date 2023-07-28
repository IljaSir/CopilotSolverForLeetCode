class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        
        if (k < 0) return 0;
        unordered_map<int, int> m;
        for (int n : nums) m[n]++;
        int res = 0;
        for (auto it : m) {
            if (k == 0) {
                if (it.second > 1) res++;
            } else {
                if (m.count(it.first + k)) res++;
            }
        }
        return res;
    }
};