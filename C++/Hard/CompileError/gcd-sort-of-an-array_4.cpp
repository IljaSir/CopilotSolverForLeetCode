class Solution {
public:
    bool gcdSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sorted(nums);
        sort(sorted.begin(), sorted.end());
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        for (int i = 2; i <= 100000; ++i) {
            int x = -1;
            for (int j = 0; j < n; ++j) {
                if (nums[j] % i == 0) {
                    if (x == -1) {
                        x = j;
                    } else {
                        x = find(p, x);
                        j = find(p, j);
                        if (x != j) {
                            p[x] = j;
                            x = -1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (find(p, i) != find(p, sorted[i] - 1)) {
                return false;
            }
        }
        return true;
    }
};