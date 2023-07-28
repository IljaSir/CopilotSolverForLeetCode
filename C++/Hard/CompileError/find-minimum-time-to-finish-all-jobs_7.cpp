class Solution {
public:
    int minimumTimeRequired(vector<int>& jobs, int k) {
        
        // 二分答案
        // 用一个数组记录每个工人的工作量，每次分配工作给工人，从工人中选取工作量最小的那个
        // 递归分配工作，直到分配完所有工作
        // 二分的上下界是工作量最大值和所有工作量之和
        int n = jobs.size();
        int left = *max_element(jobs.begin(), jobs.end());
        int right = accumulate(jobs.begin(), jobs.end(), 0);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (dfs(jobs, k, 0, mid, vector<int>(k, 0))) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    bool dfs(vector<int>& jobs, int k, int idx, int limit, vector<int>& workers) {
        if (idx == jobs.size()) return true;
        for (int i = 0; i < k; i++) {
            if (workers[i] + jobs[idx] <= limit) {
                workers[i] += jobs[idx];
                if (dfs(jobs, k, idx + 1, limit, workers)) return true;
                workers[i] -= jobs[idx];
            }
            // 如果当前工人的工作量为0，说明这个工人之前没有分配过工作
            // 那么之后的工作也不需要分配给这个工人了
            if (workers[i] == 0) break;
        }
        return false;
    }
};