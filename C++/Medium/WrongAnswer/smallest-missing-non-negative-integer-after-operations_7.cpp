class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int m = nums[0];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (m < 0) {
                if (nums[i] > 0) {
                    ans += nums[i] / value;
                    if (nums[i] % value != 0) {
                        ans++;
                    }
                }
            } else {
                ans += (nums[i] - m) / value;
                if ((nums[i] - m) % value != 0) {
                    ans++;
                }
            }
            m = nums[i] + value;
        }
        return ans;
    }
    int smallestMissingValueSubtract(vector<int>& nums, int value) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int m = nums[0];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (m < 0) {
                if (nums[i] > 0) {
                    ans += nums[i] / value;
                    if (nums[i] % value != 0) {
                        ans++;
                    }
                }
            } else {
                ans += (nums[i] - m) / value;
                if ((nums[i] - m) % value != 0) {
                    ans++;
                }
            }
            m = nums[i] - value;
        }
        return ans;
    }
};