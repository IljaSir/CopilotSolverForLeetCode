class Solution {
public:
    int minimumEffort(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        sort(tasks.begin(), tasks.end(), [](vector<int> &a, vector<int> &b) {
            return a[1] - a[0] > b[1] - b[0];
        });
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += tasks[i][0];
        }
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += tasks[i][0];
            res = min(res, max(tmp, tasks[i][1]));
        }
        return res;
    }
};