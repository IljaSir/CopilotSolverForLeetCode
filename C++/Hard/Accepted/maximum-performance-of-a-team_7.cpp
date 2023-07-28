class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        
        vector<pair<int, int>> v;
        for (int i = 0; i < n; ++i) {
            v.push_back({efficiency[i], speed[i]});
        }
        sort(v.begin(), v.end(), greater<pair<int, int>>());
        priority_queue<int, vector<int>, greater<int>> q;
        long sum = 0, res = 0;
        for (int i = 0; i < n; ++i) {
            sum += v[i].second;
            q.push(v[i].second);
            if (q.size() > k) {
                sum -= q.top();
                q.pop();
            }
            res = max(res, sum * v[i].first);
        }
        return res % 1000000007;
    }
};