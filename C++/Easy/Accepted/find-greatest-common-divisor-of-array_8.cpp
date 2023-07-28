class Solution {
public:
    int findGCD(vector<int>& nums) {
        
        int max = *max_element(nums.begin(), nums.end());
        int min = *min_element(nums.begin(), nums.end());
        int gcd = 1;
        for (int i = 1; i <= min; i++) {
            if (max % i == 0 && min % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
};