class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        
        priority_queue<int> pq;
        for (int i = 0; i < nums.size(); i++) {
            pq.push(nums[i]);
        }
        while (k--) {
            int t = pq.top();
            pq.pop();
            pq.push(t / 3);
        }
        long long ans = 0;
        while (!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
        return ans;
    }
    int maxScore(vector<int>& nums, int k) {
        long long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = max(ans, maxKelements(nums, k - i) + accumulate(nums.begin(), nums.begin() + i, 0LL));
        }
        return ans;
    }
};