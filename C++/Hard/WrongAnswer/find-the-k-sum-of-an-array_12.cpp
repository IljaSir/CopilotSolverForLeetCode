class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        long long left = INT_MIN, right = INT_MAX;
        while (left < right) {
            long long mid = (left + right + 1) / 2;
            if (check(nums, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    bool check(vector<int>& nums, int k, long long limit) {
        long long sum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (sum >= limit) {
                cnt++;
                sum = 0;
            }
        }
        return cnt >= k;
    }
};