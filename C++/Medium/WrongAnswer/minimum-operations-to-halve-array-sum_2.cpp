class Solution {
public:
    int halveArray(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        sort(nums.begin(), nums.end());
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum -= nums[i];
            cnt++;
            if (sum < nums[i]) {
                break;
            }
        }
        return cnt;
    }
};