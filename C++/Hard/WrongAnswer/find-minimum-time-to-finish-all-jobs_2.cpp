class Solution {
public:
    int minimumTimeRequired(vector<int>& jobs, int k) {
        
        int n = jobs.size();
        vector<int> workloads(k, 0);
        sort(jobs.begin(), jobs.end());
        reverse(jobs.begin(), jobs.end());
        int l = jobs[0], r = accumulate(jobs.begin(), jobs.end(), 0);
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(jobs, workloads, mid, 0)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    bool check(vector<int>& jobs, vector<int>& workloads, int limit, int idx) {
        if (idx >= jobs.size()) {
            return true;
        }
        int cur = jobs[idx];
        for (int i = 0; i < workloads.size(); ++i) {
            if (workloads[i] + cur <= limit) {
                workloads[i] += cur;
                if (check(jobs, workloads, limit, idx + 1)) {
                    return true;
                }
                workloads[i] -= cur;
            }
            if (workloads[i] == 0 || workloads[i] + cur == limit) {
                break;
            }
        }
        return false;
    }
};