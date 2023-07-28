class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        sort(nums.begin(), nums.end());
        for (int i = n - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
};