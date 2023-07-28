class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> left(n, 0), right(n, 0);
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                left[i] = nums[i];
            } else {
                left[i] = gcd(left[i-1], nums[i]);
            }
        }
        for(int i = n-1; i >= 0; i--) {
            if(i == n-1) {
                right[i] = nums[i];
            } else {
                right[i] = gcd(right[i+1], nums[i]);
            }
        }
        for(int i = 0; i < n-1; i++) {
            if(left[i] == 1 || right[i+1] == 1 || gcd(left[i], right[i+1])
        }
        return a;
    }
};