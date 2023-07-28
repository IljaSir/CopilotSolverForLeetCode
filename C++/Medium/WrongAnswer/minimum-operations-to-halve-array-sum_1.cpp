class Solution {
public:
    int halveArray(vector<int>& nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        sort(nums.begin(), nums.end());
        int half = sum / 2;
        int n = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (sum <= half) {
                break;
            }
            sum -= nums[i];
            n++;
        }
        return n;
    }
};