class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int size = nums.size();
        vector<int> parents(size, 0);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        function<int(int)> find = [&](int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        };
        
        function<void(int, int)> merge = [&](int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        };
        
        vector<int> sum(n);
        for (int i = 0; i < n; ++i) {
            sum[i] = nums[i];
        }
        
        for (auto& e : edges) {
            int x = e[0];
            int y = e[1];;
    }
};