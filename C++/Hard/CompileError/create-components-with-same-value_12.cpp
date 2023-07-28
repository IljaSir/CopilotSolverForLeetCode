class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> parents(n);
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }
        int ans = 0;
        for (auto& e : edges) {
            int x = e[0], y = e[1];
            int px = findParent(parents, x);
            int py = findParent(parents, y);
            if (px == py) {
                ++ans;
            } else {
                parents[px] = py;
            }
        }
        return ans;
    }
    int findParent(vector<int>& parents, int x) {
        if (parents[x] != x) {
            parents[x] = findParent(parents, parents[x]);
        }
        return parents[x];
    }
    int deleteEdges(vector<int>& nums, vector<vector<int>>& edges) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum % n != 0) {
            return -1;
        }
        int target = sum / n;
        vector<int> parents(n);
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }
        vector<int> values(n, 0);
        for (int i = 0; i < n; ++i) {
            values[i] = nums[i];
        }
        int ans = 0;
        for (auto& e : edges) {
            int x = e[0], y = e[1];
            int px = findParent(parents, x);
            int py = findParent(parents, y);
            if (px == py) {
                ++ans;
            } else {
                if (values[px] + values[py] != target) {
                    ++ans;
                } else {
                    parents[px] = py;
                    values[py] += values[px];
                }
            }
        }
        return ans;
    }
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        vector<int> nums(n, 1);
        int ans = deleteEdges(nums, edges);
        if (ans < 0) {
            return -1;
        }
        vector<int> nums1 = nums;
        vector<int> nums2 = nums;
    }
};