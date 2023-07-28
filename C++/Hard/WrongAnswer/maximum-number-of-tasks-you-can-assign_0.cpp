class Solution {
public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        
        int n = tasks.size();
        int m = workers.size();
        sort(tasks.begin(), tasks.end());
        sort(workers.begin(), workers.end());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = 0;
            int r = m;
            int mid;
            while (l < r) {
                mid = (l + r) / 2;
                if (workers[mid] + pills * strength >= tasks[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l + pills >= m) {
                return n - i;
            }
            ans = max(ans, n - i);
        }
        return ans;
    }
};