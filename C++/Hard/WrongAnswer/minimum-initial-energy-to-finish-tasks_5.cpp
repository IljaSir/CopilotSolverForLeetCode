class Solution {
public:
    int minimumEffort(vector<vector<int>>& tasks) {
        
        int n = tasks.size();
        sort(tasks.begin(), tasks.end(), [](auto& a, auto& b) {
            return a[1] - a[0] > b[1] - b[0];
        });
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans + tasks[i][0], tasks[i][1]);
        }
        return ans;
    }
};