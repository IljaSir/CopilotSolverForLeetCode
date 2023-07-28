class Solution {
public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        
        sort(tasks.begin(), tasks.end());
        sort(workers.begin(), workers.end());
        int n = tasks.size(), m = workers.size();
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, tasks, workers, pills, strength)) l = mid;
            else r = mid - 1;
        }
        return l;
    }
    
    bool check(int mid, vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        int n = tasks.size(), m = workers.size();
        int l = 0, r = 0, cnt = 0;
        for (int i = 0; i < m; i++) {
            while (l < n && tasks[l] > workers[i]) l++;
            if (l == n) break;
            r = max(r, l);
            while (r < n && tasks[r] <= workers[i] + pills * strength) r++;
            cnt += r - l;
            if (cnt >= mid) return true;
        }
        return false;
    }
};