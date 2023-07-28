class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<long long> pre_sum(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            pre_sum[i] = pre_sum[i - 1] + nums[i - 1];
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            long long cur = nums[i];
            long long cnt = i + 1;
            long long rem = n - i - 1;
            long long left = k - cnt;
            if (left < 0) break;
            if (left >= rem) {
                ans = max(ans, cur * cnt + pre_sum[n]);
            } else {
                ans = max(ans, cur * cnt + pre_sum[n] - pre_sum[n - left]);
            }
        }
        return ans;
    }
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        int n = profits.size();
        vector<pair<int, int>> p(n);
        for (int i = 0; i < n; ++i) {
            p[i] = {capital[i], profits[i]};
        }
        sort(p.begin(), p.end());
        priority_queue<int> pq;
        int i = 0;
        while (k--) {
            while (i < n && p[i].first <= w) {
                pq.push(p[i].second);
                ++i;
            }
            if (pq.empty()) break;
            w += pq.top();
            pq.pop();
        }
        return w;
    }
    int findMaximizedCapital2(int k, int w, vector<int>& profits, vector<int>& capital) {
        int n = profits.size();
        vector<pair<int, int>> p(n);
        for (int i = 0; i < n; ++i) {
            p[i] = {capital[i], profits[i]};
        }
        sort(p.begin(), p.end());
        int i = 0;
        while (k--) {
            while (i < n && p[i].first <= w) {
                ++i;
            }
            if (i == 0) break;
            w += maximumTop(profits, i);
        }
        return w;
    }
};