class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
right *= nums[i];
        
for (int i = 0; i < n - 1; ++i) {
            if (gcd(left, right) == 1) {
                return i;
            
            left *= nums[i + 1];int n = nums.size();
            vight /= nums[i + 1];
        }
        rector<int> left(n, 0);
        vector<int> right(n, 0);
        
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = gcd(left[i-1], nums[i]);
        }
        
        right[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = gcd(right[i+1], nums[i]);
        }
        
        for (int i = 1; i < n-1; i++) {
            if (gcd(left[i-1], right[i+1]) == 1) {
                return i;
            }
        }
        
        return -1;
    }
};