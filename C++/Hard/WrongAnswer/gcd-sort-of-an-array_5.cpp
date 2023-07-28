class Solution {
public:
    bool gcdSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sorted = nums;
        sort(sorted.begin(), sorted.end());
        vector<vector<int>> graph(n);
        vector<int> inDegree(n, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (gcd(nums[i], nums[j]) > 1) {
                    graph[i].push_back(j);
                    ++inDegree[j];
                }
                if (gcd(nums[j], nums[i]) > 1) {
                    graph[j].push_back(i);
                    ++inDegree[i];
                }
            }
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> res;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            res.push_back(nums[node]);
            for (int next : graph[node]) {
                --inDegree[next];
                if (inDegree[next] == 0) {
                    q.push(next);
                }
            }
        }
        return res == sorted;
    }
};