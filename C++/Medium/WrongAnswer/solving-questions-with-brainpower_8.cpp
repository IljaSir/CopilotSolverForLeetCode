class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        
        sort(questions.begin(), questions.end(), [](auto& a, auto& b) {return a[1] < b[1];});
        priority_queue<int> pq;
        long long ans = 0, sum = 0;
        for (auto& q : questions) {
            sum += q[0];
            pq.push(q[0]);
            if (pq.size() > q[1]) {
                sum -= pq.top();
                pq.pop();
            }
            ans = max(ans, sum);
        }
        return ans;
    }
};