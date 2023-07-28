class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        
        priority_queue<int> pq;
        for (int n : nums) {
            pq.push(n);
        }
        while (k-- > 0) {
            int n = pq.top();
            pq.pop();
            pq.push(n / 3);
            if (n % 3 == 0) {
                pq.push(n / 3);
                pq.push(n / 3);
            }
            else if (n % 3 == 1) {
                pq.push(n / 3);
                pq.push(n / 3 + 1);
            }
            else {
                pq.push(n / 3 + 1);
                pq.push(n / 3 + 1);
            }
        }
        long long res = 0;
        while (!pq.empty()) {
            res += pq.top();
            pq.pop();
        }
        return res;
    }
    int maximumScore(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> left(n, -1), right(n, n);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            while (!s.empty() && nums[s.top()] >= nums[i]) {
                s.pop();
            }
            if (!s.empty()) {
                left[i] = s.top();
            }
            s.push(i);
        }
        while (!s.empty()) {
            s.pop();
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && nums[s.top()] >= nums[i]) {
                s.pop();
            }
            if (!s.empty()) {
                right[i] = s.top();
            }
            s.push(i);
        }
        long long res = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] < k && k < right[i]) {
                int l = k - left[i], r = right[i] - k;
                res = max(res, maxKelements(nums, l) + maxKelements(nums, r) + nums[i]);
            }
        }
        return res;
    }
};