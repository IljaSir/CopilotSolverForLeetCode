class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        
        sort(questions.begin(), questions.end(), [](const vector<int> &a, const vector<int> &b) {
            return a[0] - a[1] > b[0] - b[1];
        });
        int n = questions.size();
        long long ans = 0, sum = 0;
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i = 0; i < n; i++) {
            int points = questions[i][0], brainpower = questions[i][1];
            sum += points;
            pq.push(points);
            if (pq.size() > brainpower) {
                sum -= pq.top();
                pq.pop();
            }
            ans = max(ans, sum);
        }
        return ans;
    }
};