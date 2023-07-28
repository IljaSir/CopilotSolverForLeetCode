class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n < 2) return 0;
        sort(nums.begin(), nums.end());
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + k > nums[n - 1]) break;
            int j = i + 1;
            while (j < n && nums[j] < nums[i] + k) j++;
            if (j < n && nums[j] == nums[i] + k) res++;
        }
        return res;
    }
};