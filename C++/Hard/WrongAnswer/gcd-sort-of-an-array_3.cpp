class Solution {
public:
    bool gcdSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sorted(nums);
        sort(sorted.begin(), sorted.end());
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        function<int(int)> find = [&](int x) { return p[x] == x ? x : p[x] = find(p[x]); };
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (__gcd(nums[i], nums[j]) > 1) {
                    p[find(i)] = find(j);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (find(i) != find(0)) {
                return false;
            }
        }
        return true;
    }
};