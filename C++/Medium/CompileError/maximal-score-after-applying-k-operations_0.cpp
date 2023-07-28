class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        
        priority_queue<int> pq;
        for (int i = 0; i < nums.size(); ++i) {
            pq.push(nums[i]);
        }
        for (int i = 0; i < k; ++i) {
            int x = pq.top();
            pq.pop();
            pq.push(x / 3);
        }
        long long ans = 0;
        while (!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
        return ans;
    }
    long long maxKelements(vector<int>& nums, int k) {
        priority_queue<int> pq;
        for (int i = 0; i < nums.size(); ++i) {
            pq.push(nums[i]);
        }
        for (int i = 0; i < k; ++i) {
            int x = pq.top();
            pq.pop();
            pq.push(x / 3);
        }
        long long ans = 0;
        while (!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
        return ans;
    }
    int maxScore(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> leftSum(n + 1);
        vector<int> rightSum(n + 1);
        for (int i = 0; i < n; ++i) {
            leftSum[i + 1] = leftSum[i] + nums[i];
        }
        for (int i = n - 1; i >= 0; --i) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i <= k; ++i) {
            if (i <= n && k - i <= n) {
                ans = max(ans, leftSum[i] + rightSum[k - i]);
            }
        }
        return ans;
    }
    int maxScore(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> leftSum(n + 1);
        vector<int> rightSum(n + 1);
        for (int i = 0; i < n; ++i) {
            leftSum[i + 1] = leftSum[i] + nums[i];
        }
        for (int i = n - 1; i >= 0;
    }
};