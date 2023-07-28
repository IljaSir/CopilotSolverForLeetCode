class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        
        long long n = nums.size();
        long long ans = 0;
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum < k) {
                ans += (i + 1);
            } else {
                int l = 0;
                int r = i;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (sum - nums[mid] >= k) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (sum - nums[l] >= k) {
                    l++;
                }
                ans += (i - l);
                sum -= nums[l];
            }
        }
        return ans;
    }
};