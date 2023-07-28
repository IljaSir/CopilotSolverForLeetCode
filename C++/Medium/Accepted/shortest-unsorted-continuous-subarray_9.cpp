class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        
        int n = nums.size();
        if(n <= 1) return 0;
        vector<int> sorted(nums);
        sort(sorted.begin(), sorted.end());
        int l = 0, r = n - 1;
        while(l < n && nums[l] == sorted[l]) l++;
        while(r > 0 && nums[r] == sorted[r]) r--;
        if(l < r) return r - l + 1;
        return 0;
    }
};