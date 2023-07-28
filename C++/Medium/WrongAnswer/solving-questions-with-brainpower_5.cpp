class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        
        sort(questions.begin(), questions.end(), [](auto& a, auto& b) {
            return a[1] + a[0] > b[1] + b[0];
        });
        long long ans = 0, cur = 0;
        priority_queue<int> pq;
        for (auto& q : questions) {
            pq.push(q[0]);
            cur += q[0];
            if (pq.size() > q[1]) {
                cur -= pq.top();
                pq.pop();
            }
            ans = max(ans, cur);
        }
        return ans;
    }
};