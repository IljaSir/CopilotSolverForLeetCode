class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        
        unordered_set<int> set;
        for (auto n : nums) {
            set.insert(n);
        }
        int res = 0;
        for (auto n : nums) {
            if (set.find(n) != set.end()) {
                // find the left bound
                int l = n - 1;
                while (set.find(l) != set.end()) {
                    set.erase(l);
                    l--;
                }
                // find the right bound
                int r = n + 1;
                while (set.find(r) != set.end()) {
                    set.erase(r);
                    r++;
                }
                res = max(res, r - l - 1);
            }
        }
        return res;
    }
};