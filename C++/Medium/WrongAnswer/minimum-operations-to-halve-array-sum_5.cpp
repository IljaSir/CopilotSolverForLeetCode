class Solution {
public:
    int halveArray(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        int half = sum / 2;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > half) {
                int tmp = nums[i];
                while (tmp > half) {
                    tmp /= 2;
                    ans++;
                }
                nums[i] = tmp;
            }
        }
        sort(nums.begin(), nums.end());
        int i = 0;
        while (sum > half) {
            sum -= nums[i];
            ans++;
            i++;
        }
        return ans;
    }
};