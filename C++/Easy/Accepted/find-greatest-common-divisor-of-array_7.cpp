class Solution {
public:
    int findGCD(vector<int>& nums) {
        
        int min = *min_element(nums.begin(), nums.end());
        int max = *max_element(nums.begin(), nums.end());
        int gcd = 0;
        for (int i = 1; i <= min && i <= max; i++) {
            if (min % i == 0 && max % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
};