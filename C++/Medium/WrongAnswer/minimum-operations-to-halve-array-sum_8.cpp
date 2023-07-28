class Solution {
public:
    int halveArray(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end(), greater<int>());
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int half = sum / 2;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += 1;
            sum -= nums[i];
            if (sum <= half) {
                break;
            }
        }
        return ans;
    }
};