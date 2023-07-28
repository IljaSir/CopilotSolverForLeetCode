class Solution {
public:
    int halveArray(vector<int>& nums) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int half = sum / 2;
        int cur = 0;
        int res = 0;
        sort(nums.begin(), nums.end(), greater<int>());
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            res++;
            if (cur > half) {
                break;
            }
        }
        return res;
    }
};