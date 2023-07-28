class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        function<int(int)> find = [&](int x) {
            return p[x] == x ? x : p[x] = find(p[x]);
        };
        for (auto& e : edges) {
            p[find(e[0])] = find(e[1]);
        }
        vector<int> cnt(n);
        for (int i = 0; i < n; ++i) {
            ++cnt[find(i)];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (cnt[i] > 1) {
                ans += cnt[i] - 1;
            }
        }
        return ans;
    }
    int maxValue(vector<int>& nums, vector<vector<int>>& edges) {
        int n = nums.size();
        vector<int> sum(n);
        for (int i = 0; i < n; ++i) {
            sum[i] = nums[i];
        }
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        function<int(int)> find = [&](int x) {
            return p[x] == x ? x : p[x] = find(p[x]);
        };
        function<void(int, int)> merge = [&](int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                p[x] = y;
                sum[y] += sum[x];
            }
        };
        for (auto& e : edges) {
            merge(e[0], e[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (find(i) == i) {
                if (sum[i] % cnt[i] != 0) {
                    return -1;
                }
                ans += componentValue(nums, edges);
            }
        }
        return ans;
    }
};