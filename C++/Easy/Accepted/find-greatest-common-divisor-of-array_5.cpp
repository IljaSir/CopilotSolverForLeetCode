class Solution {
public:
    int findGCD(vector<int>& nums) {
        
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int gcd = 1;
        for (int i = 2; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
};