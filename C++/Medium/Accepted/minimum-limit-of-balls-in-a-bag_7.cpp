class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        
        int l = 1, r = 1e9;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (canDivide(nums, maxOperations, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    
    bool canDivide(vector<int>& nums, int maxOperations, int limit) {
        int ops = 0;
        for (int num : nums) {
            ops += (num - 1) / limit;
        }
        return ops <= maxOperations;
    }
};