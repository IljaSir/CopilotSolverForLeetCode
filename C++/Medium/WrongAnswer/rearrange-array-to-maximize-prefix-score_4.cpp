class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n, 0);
        for (int i = 0; i < n; i++) {
            prefix[i] = nums[i];
            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }
        sort(prefix.begin(), prefix.end());
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (prefix[i] > 0) {
                res++;
            }
        }
        return res;
    }
};