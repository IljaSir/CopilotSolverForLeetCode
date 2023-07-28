class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        
        int n = nums.size();
        int maxVal = *max_element(nums.begin(), nums.end());
        vector<int> f(maxVal + 1, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 2; j * j <= nums[i]; j++) {
                if (nums[i] % j == 0) {
                    f[j] = i;
                    f[nums[i] / j] = i;
                }
            }
        }
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        for (int i = 0; i < n; i++) {
            for (int j = 2; j * j <= nums[i]; j++) {
                if (nums[i] % j == 0) {
                    p[find(p, f[j])] = find(p, f[nums[i] / j]);
                }
            }
        }
        vector<int> count(n);
        for (int i = 0; i < n; i++) {
            count[find(p, i)]++;
        }
        return *max_element(count.begin(), count.end());
    }
};