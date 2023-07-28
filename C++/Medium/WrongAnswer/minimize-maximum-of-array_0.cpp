class Solution {
public:
    int minimizeArrayValue(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int avg = sum / (n - 1);
        if (sum % (n - 1) != 0) {
            avg++;
        }
        return avg;
    }
};