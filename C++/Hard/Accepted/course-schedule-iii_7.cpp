class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        
        sort(courses.begin(), courses.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
        int n = courses.size();
        priority_queue<int> pq;
        int time = 0;
        for (int i = 0; i < n; i++) {
            pq.push(courses[i][0]);
            time += courses[i][0];
            if (time > courses[i][1]) {
                time -= pq.top();
                pq.pop();
            }
        }
        return pq.size();
    }
};