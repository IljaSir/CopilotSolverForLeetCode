class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        
        sort(courses.begin(), courses.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
        priority_queue<int> pq;
        int cur = 0;
        for (auto& c : courses) {
            if (cur + c[0] <= c[1]) {
                pq.push(c[0]);
                cur += c[0];
            } else if (!pq.empty() && pq.top() > c[0]) {
                cur += c[0] - pq.top();
                pq.pop();
                pq.push(c[0]);
            }
        }
        return pq.size();
    }
};