class Solution {
public:
    int halveArray(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        sort(nums.begin(), nums.end());
        int res = 0;
        int cur = 0;
        for(int i = n - 1; i >= 0; i--) {
            cur += nums[i];
            res++;
            if(cur >= (sum + 1) / 2) {
                break;
            }
        }
        return res;
    }
};