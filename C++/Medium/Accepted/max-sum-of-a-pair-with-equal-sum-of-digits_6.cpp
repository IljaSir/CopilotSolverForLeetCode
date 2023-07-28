class Solution {
public:
    int maximumSum(vector<int>& nums) {
        
        int res = -1;
        vector<int> sum(100, -1);
        for (int n : nums) {
            int s = 0;
            int m = n;
            while (m) {
                s += m % 10;
                m /= 10;
            }
            if (sum[s] != -1) {
                res = max(res, sum[s] + n);
            }
            sum[s] = max(sum[s], n);
        }
        return res;
    }
};