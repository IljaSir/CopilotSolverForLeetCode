class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        
        int n = nums.size();
        int x = 0;
        for (int i = 0; i < n; i++) {
            x ^= nums[i];
        }
        int y = x & (-x);
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] & y) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return {a, b};
    }
};