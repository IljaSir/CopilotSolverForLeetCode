class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        
        vector<int> ones;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == 1) ones.push_back(i);
        }
        int res = INT_MAX;
        int n = ones.size();
        int l = 0, r = k - 1;
        int sum = 0;
        for (int i = l; i <= r; ++i) {
            sum += ones[i];
        }
        int mid = (k - 1) / 2;
        int median = ones[mid];
        res = min(res, sum - median * (k - 1 - mid) - median * mid);
        while (r < n - 1) {
            sum += ones[++r] - ones[++l - 1];
            median = ones[l + mid];
            res = min(res, sum - median * (k - 1 - mid) - median * mid);
        }
        return res;
    }
};