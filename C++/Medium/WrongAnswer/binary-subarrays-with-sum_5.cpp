class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        
        int n = nums.size();
        int l = 0, r = 0;
        int sum = 0;
        int ans = 0;
        while (r < n) {
            sum += nums[r];
            if (sum == goal) {
                int temp = r + 1;
                while (temp < n && nums[temp] == 0) {
                    temp++;
                }
                int count = temp - r;
                ans += count;
                r = temp;
            } else if (sum > goal) {
                while (l <= r && sum > goal) {
                    sum -= nums[l];
                    l++;
                }
                if (sum == goal) {
                    int temp = r + 1;
                    while (temp < n && nums[temp] == 0) {
                        temp++;
                    }
                    int count = temp - r;
                    ans += count;
                    r = temp;
                } else {
                    r++;
                }
            } else {
                r++;
            }
        }
        return ans;
    }
};