class Solution {
public:
    int totalHammingDistance(vector<int>& nums) {
        
        int n = nums.size();
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int j = 0; j < n; j++) {
                ones += (nums[j] >> i) & 1;
            }
            result += ones * (n - ones);
        }
        return result;
    }
};