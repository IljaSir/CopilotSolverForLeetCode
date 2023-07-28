class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        
        priority_queue<int> pq;
        for (int num : nums) {
            pq.push(num);
        }
        for (int i = 0; i < k; i++) {
            int num = pq.top();
            pq.pop();
            pq.push(num / 3);
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
        vector<int> left(k + 1, 0);
        vector<int> right(k + 1, 0);
        for (int i = 1; i <= k; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= k; i++) {
            right[i] = right[i - 1] + nums[n - i];
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = max(ans, left[i] + right[k - i] + maxKelements(nums, k - i));
        }
        return ans;
    }
};