class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        
        unordered_map<int, int> map;
        for (auto i : nums) {
            map[i]++;
        }
        int res = 0;
        for (auto& [key, val] : map) {
            if (k == 0) {
                if (val > 1) {
                    res++;
                }
            } else {
                if (map.count(key + k)) {
                    res++;
                }
            }
        }
        return res;
    }
};