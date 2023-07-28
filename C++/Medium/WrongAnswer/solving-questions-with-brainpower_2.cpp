class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        
        sort(questions.begin(), questions.end(), [](const vector<int> &a, const vector<int> &b) {
            return a[1] + a[0] > b[1] + b[0];
        });
        long long res = 0;
        priority_queue<int> pq;
        for (const auto &q : questions) {
            pq.push(q[0]);
            res += q[0];
            if (pq.size() > q[1]) {
                res -= pq.top();
                pq.pop();
            }
        }
        return res;
    }
};