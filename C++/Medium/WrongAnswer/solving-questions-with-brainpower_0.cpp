class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        
        sort(questions.begin(), questions.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] - a[1] > b[0] - b[1];
        });
        long long res = 0, sum = 0;
        priority_queue<int, vector<int>, greater<int>> pq;
        for (auto& q : questions) {
            sum += q[1];
            pq.push(q[1]);
            if (sum > q[0]) {
                sum -= pq.top();
                pq.pop();
            }
            res = max(res, sum);
        }
        return res;
    }
};