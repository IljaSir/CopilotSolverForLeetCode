class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        
        priority_queue<int, vector<int>, greater<int> > pq;
        for (int i = 0; i < nums.size(); ++i) {
            pq.push(nums[i]);
        }
        long long ans = 0;
        while (k-- > 0) {
            int x = pq.top();
            pq.pop();
            ans += x;
            pq.push((x + 2) / 3);
        }
        return ans;
    }
    long long maxScore(vector<int>& nums, int k) {
        long long ans = 0;
        for (int i = 0; i < k; ++i) {
            ans += nums[i];
        }
        long long cur = ans;
        for (int i = 0; i < k; ++i) {
            cur = cur - nums[k - 1 - i] + nums[nums.size() - 1 - i];
            ans = max(ans, cur);
        }
        return ans + maxKelements(nums, k);
    }
};