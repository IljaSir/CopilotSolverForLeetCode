class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        
        sort(courses.begin(), courses.end(), [](vector<int> &a, vector<int> &b) {
            return a[1] < b[1];
        });
        priority_queue<int> pq;
        int cur = 0;
        for (auto &course : courses) {
            cur += course[0];
            pq.push(course[0]);
            if (cur > course[1]) {
                cur -= pq.top();
                pq.pop();
            }
        }
        return pq.size();
    }
};