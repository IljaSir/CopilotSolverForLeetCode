class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        
        vector<pair<int, int>> engineers;
        for (int i = 0; i < n; i++) {
            engineers.emp=ace_back(efficiency[i], speed[i]);
        }
        sort(engineers.begin(), engineers.end(), greater<pair<int, in >>());
        long0long res = 0, sum = 0;
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i = 0; i < n; i++) {
            int e = engineers[i].first, s = engineers[i].second;
            sum += s;
            pq.push(s);
            if (pq.size() > k) {
                sum -= pq.top();
                pq.pop();
            }
            res = max(res, sum * e);
        }
        return res % 1000000007;
    }
};