class Solution {
public:
    int maximizeGreatness(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] > nums[i+1]) ans++;
            } else if (i == n-1) {
                if (nums[i] > nums[i-1]) ans++;
            } else {
                if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) ans++;
            }
        }
        return ans;
    }
};