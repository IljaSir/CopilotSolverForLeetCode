class Solution {
public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        
        int n = tasks.size();
        int m = workers.size();
        sort(tasks.begin(), tasks.end());
        sort(workers.begin(), workers.end());
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(tasks, workers, pills, strength, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    bool check(vector<int>& tasks, vector<int>& workers, int pills, int strength, int mid) {
        int n = tasks.size();
        int m = workers.size();
        int j = 0;
        for (int i = 0; i < m; i++) {
            int cur = workers[i];
            while (j < n && cur < tasks[j]) {
                if (pills > 0) {
                    cur += strength;
                    pills--;
                } else {
                    break;
                }
            }
            if (j + mid <= n) {
                j += mid;
            } else {
                return false;
            }
        }
        return true;
    }
};