class Solution {
public:
    int findGCD(vector<int>& nums) {
        
        int min = 1001;
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int gcd = 1;
        for (int i = 1; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
};