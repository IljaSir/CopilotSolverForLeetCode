class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        
        sort(courses.begin(), courses.end(), [](vector<int> a, vector<int> b) {
            return a[1] < b[1];
        });
        priority_queue<int> q;
        int time = 0;
        for (auto c : courses) {
            q.push(c[0]);
            time += c[0];
            if (time > c[1]) {
                time -= q.top();
                q.pop();
            }
        }
        return q.size();
    }
};