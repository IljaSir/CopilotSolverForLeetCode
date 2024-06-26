class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        
        int left = 0;
        int right = 0;
        for (int job : jobs) {
            left = Math.max(left, job);
            right += job;
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(jobs, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] jobs, int k, int limit) {
        int[] workloads = new int[k];
        return backtrack(jobs, workloads, 0, limit);
    }

    public boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
        if (i >= jobs.length) {
            return true;
        }
        int cur = jobs[i];
        for (int j = 0; j < workloads.length; ++j) {
            if (workloads[j] + cur <= limit) {
                workloads[j] += cur;
                if (backtrack(jobs, workloads, i + 1, limit)) {
                    return true;
                }
                workloads[j] -= cur;
            }
            if (workloads[j] == 0 || workloads[j] + cur == limit) {
                break;
            }
        }
        return false;
    }
}