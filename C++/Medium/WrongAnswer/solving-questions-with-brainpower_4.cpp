class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        
        sort(questions.begin(), questions.end(), [](vector<int>& a, vector<int>& b) {
            return a[1] + a[0] > b[1] + b[0];
        });
        long long res = 0, cur = 0;
        priority_queue<int> pq;
        for (auto& q : questions) {
            cur += q[0];
            pq.push(q[0]);
            if (pq.size() > q[1]) {
                cur -= pq.top();
                pq.pop();
            }
            res = max(res, cur);
        }
        return res;
    }
};