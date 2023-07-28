class Solution {
public:
    int maximumTastiness(vector<int>& price, int k) {
        
        int n = price.size();
        sort(price.begin(), price.end());
        priority_queue<int, vector<int>, greater<int>> q;
        int ans = 0, sum = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= k) {
                sum -= q.top();
                q.pop();
            }
            sum += price[i];
            q.push(price[i]);
            if (i >= k - 1) ans = max(ans, sum - q.top());
        }
        return ans;
    }
};