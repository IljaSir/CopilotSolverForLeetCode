class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        
        int n = nums.size();
        int xorNums = 0;
        for (int i = 0; i < n; i++) {
            xorNums ^= nums[i];
        }
        int rightOne = xorNums & (~xorNums + 1);
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] & rightOne) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return vector<int>{a, b};
    }
};