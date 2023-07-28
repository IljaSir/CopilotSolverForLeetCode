class Solution {
public:
    int minimumTimeRequired(vector<int>& jobs, int k) {
        
        int n = jobs.size();
        vector<int> workloads(k, 0);
        sort(jobs.begin(), jobs.end());
        int l = jobs.back(), r = accumulate(jobs.begin(), jobs.end(), 0);
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(jobs, workloads, mid, n - 1))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    bool check(vector<int>& jobs, vector<int>& workloads, int limit, int i) {
        if (i < 0)
            return true;
        int cur = jobs[i];
        for (int j = 0; j < workloads.size(); j++) {
            if (workloads[j] + cur <= limit) {
                workloads[j] += cur;
                if (check(jobs, workloads, limit, i - 1))
                    return true;
                workloads[j] -= cur;
            }
            if (workloads[j] == 0 || workloads[j] + cur == limit)
                break;
        }
        return false;
    }
};