class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        
        int n = nums.size();
        int x = 0;
        for (int i = 0; i < n; i++) {
            x ^= nums[i];
        }
        int mask = x & (-x);
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] & mask) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return {a, b};
    }
};