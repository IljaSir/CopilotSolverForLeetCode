class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        
        sort(questions.begin(), questions.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] + a[0] > b[1] + b[0];
        });
        long long res = 0, cur = 0;
        priority_queue<int> q;
        for (auto& qn : questions) {
            cur += qn[0];
            q.push(qn[0]);
            if (q.size() > qn[1]) {
                cur -= q.top();
                q.pop();
            }
            res = max(res, cur);
        }
        return res;
    }
};