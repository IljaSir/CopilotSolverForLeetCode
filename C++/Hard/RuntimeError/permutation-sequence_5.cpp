class Solution {
public:
    string getPermutation(int n, int k) {
        
        vector<int> nums(n);
        iota(nums.begin(), nums.end(), 1);
        int fac = 1;
        for (int i = 2; i < n; ++i) {
            fac *= i;
        }
        string ans;
        for (int i = n - 1; i >= 0; --i) {
            int idx = (k - 1) / fac;
            ans.push_back(nums[idx] + '0');
            nums.erase(nums.begin() + idx);
            if (i > 0) {
                k = k % fac;
                fac /= i;
            }
        }
        return ans;
    }
};