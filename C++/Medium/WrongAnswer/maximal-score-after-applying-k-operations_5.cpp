class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        
        priority_queue<int> pq;
        for (int n : nums) {
            pq.push(n);
        }
        while (k--) {
            int top = pq.top();
            pq.pop();
            pq.push(top / 3);
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
        vector<int> left(n, k);
        vector<int> right(n, k);
        for (int i = k - 1; i >= 0; i--) {
            if (nums[i] >= nums[left[i + 1]]) {
                left[i] = left[i + 1];
            }
        }
        for (int i = k + 1; i < n; i++) {
            if (nums[i] >= nums[right[i - 1]]) {
                right[i] = right[i - 1];
            }
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            int k = i - l + 1 + r - i;
            ans = max(ans, maxKelements(nums, k));
        }
        return ans;
    }
};