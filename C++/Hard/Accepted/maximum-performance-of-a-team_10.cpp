class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        
        vector<pair<int, int>> v;
        for(int i = 0; i < n; ++i) {
            v.push_back({efficiency[i], speed[i]});
        }
        sort(v.rbegin(), v.rend());
        priority_queue<int, vector<int>, greater<int>> q;
        long long sum = 0, res = 0;
        for(auto& p : v) {
            if(q.size() == k) {
                sum -= q.top();
                q.pop();
            }
            sum += p.second;
            q.push(p.second);
            res = max(res, sum * p.first);
        }
        return res % 1000000007;
    }
};