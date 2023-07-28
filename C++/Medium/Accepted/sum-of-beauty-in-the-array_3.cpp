class Solution {
public:
    int sumOfBeauties(vector<int>& nums) {
        
        int ans = 0;
        int n = nums.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for(int i=1; i<n; i++) {
            left[i] = max(left[i-1], nums[i]);
        }
        for(int i=n-2; i>=0; i--) {
            right[i] = min(right[i+1], nums[i]);
        }
        for(int i=1; i<n-1; i++) {
            if(nums[i] > left[i-1] && nums[i] < right[i+1]) {
                ans += 2;
            } else if(nums[i] > nums[i-1] && nums[i] < nums[i+1]) {
                ans += 1;
            }
        }
        return ans;
    }
};