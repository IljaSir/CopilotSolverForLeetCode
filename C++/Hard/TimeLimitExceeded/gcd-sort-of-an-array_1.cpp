class Solution {
public:
    bool gcdSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> a = nums;
        sort(a.begin(), a.end());
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        function<int(int)> find = [&](int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        };
        auto unite = [&](int x, int y) {
            x = find(x);
            y = find(y);
            p[x] = y;
        };
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (__gcd(nums[i], nums[j]) > 1) {
                    unite(i, j);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (find(i) != find(lower_bound(a.begin(), a.end(), nums[i]) - a.begin())) {
                return false;
            }
        }
        return true;
    }
};