class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        
        sort(courses.begin(), courses.end(), [](const auto& a, const auto& b) {
            return a[1] < b[1];
        });
        priority_queue<int> pq;
        int time = 0;
        for (const auto& c : courses) {
            if (time + c[0] <= c[1]) {
                time += c[0];
                pq.push(c[0]);
            } else if (!pq.empty() && pq.top() > c[0]) {
                time += c[0] - pq.top();
                pq.pop();
                pq.push(c[0]);
            }
        }
        return pq.size();
    }
};