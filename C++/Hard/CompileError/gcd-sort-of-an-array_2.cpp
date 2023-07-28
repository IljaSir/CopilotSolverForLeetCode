class Solution {
public:
    bool gcdSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        auto find = [&](int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        };
        auto merge = [&](int x, int y) {
            parent[find(x)] = parent[find(y)];
        };
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (__gcd(nums[i], nums[j]) > 1) {
                    merge(i, j);
                }
            }
        }
        vector<int> sortedNums = nums;
        sort(sortedNums.begin(), sortedNums.end());
        for (int i = 0; i < n; i++) {
            if (find(i) != find(lower_bound(sortedNums.begin(), sortedNums.end(), nums[i]) - sortedNums.begin())) {
                return false;
            }
        }
        return true;
    }
};