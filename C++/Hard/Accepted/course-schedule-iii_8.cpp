class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        
        sort(courses.begin(), courses.end(), [](vector<int> a, vector<int> b) { return a[1] < b[1]; });
        priority_queue<int, vector<int>, less<int>> pq;
        int cur = 0, cnt = 0;
        for (auto course: courses) {
            if (cur + course[0] <= course[1]) {
                cur += course[0];
                pq.push(course[0]);
                cnt++;
            }
            else if (!pq.empty() && pq.top() > course[0]) {
                cur = cur - pq.top() + course[0];
                pq.pop();
                pq.push(course[0]);
            }
        }
        return cnt;
    }
};