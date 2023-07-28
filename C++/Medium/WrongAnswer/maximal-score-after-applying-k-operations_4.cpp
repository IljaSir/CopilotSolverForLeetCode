class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        
        priority_queue<int> pq;
        for (int num : nums) {
            pq.push(num);
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
    int maximumScore(int64_t a, int64_t b, int64_t c) {
        if (a < b) {
            swap(a, b);
        }
        if (b < c) {
            swap(b, c);
        }
        if (a < b) {
            swap(a, b);
        }
        if (a >= b + c) {
            return (int)(b + c);
        }
        return (int)(a + (b + c - a) / 2);
    }
    int maximumScore(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> left(n);
        vector<int> right(n);
        for (int i = 0; i < n; ++i) {
            left[i] = i;
            while (left[i] > 0 && nums[left[i] - 1] >= nums[i]) {
                left[i] = left[left[i] - 1];
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            right[i] = i;
            while (right[i] < n - 1 && nums[right[i] + 1] >= nums[i]) {
                right[i] = right[right[i] + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = left[i], r = right[i];
            if (l <= k && k <= r) {
                ans = max(ans, nums[i] * (r - l + 1));
            }
        }
        return ans;
    }
};