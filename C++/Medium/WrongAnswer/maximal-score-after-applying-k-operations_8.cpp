class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        
        priority_queue<long long, vector<long long>, greater<long long>> pq;
        for (int num : nums) {
            pq.push(num);
        }
        while (k--) {
            int top = pq.top();
            pq.pop();
            pq.push((top + 1) / 2);
        }
        long long ans = 0;
        while (!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
        return ans;
    }
    int maximumScore(vector<int>& nums, int k) {
        int n = nums.size();
        int l = k, r = k;
        long long ans = nums[k];
        while (l > 0 || r < n - 1) {
            if (l == 0) {
                r++;
            } else if (r == n - 1) {
                l--;
            } else {
                if (nums[l - 1] < nums[r + 1]) {
                    r++;
                } else {
                    l--;
                }
            }
            ans = max(ans, (long long)nums[k] * (r - l + 1) + maxKelements(nums, k - l) + maxKelements(nums, r - k));
        }
        return ans;
    }
};