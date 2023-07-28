class Solution {
public:
    int minimumTimeRequired(vector<int>& jobs, int k) {
        
        int n = jobs.size();
        vector<int> workers(k, 0);
        sort(jobs.begin(), jobs.end());
        int l = jobs.back(), r = accumulate(jobs.begin(), jobs.end(), 0);
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(jobs, workers, mid, n - 1)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    bool check(vector<int>& jobs, vector<int>& workers, int limit, int i) {
        if (i < 0) return true;
        int cur = jobs[i];
        for (int &worker : workers) {
            if (worker + cur <= limit) {
                worker += cur;
                if (check(jobs, workers, limit, i - 1)) return true;
                worker -= cur;
            }
            if (worker == 0 || worker + cur == limit) break;
        }
        return false;
    }
};