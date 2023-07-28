class Solution {
public:
    int movesToMakeZigzag(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> a(nums);
        vector<int> b(nums);
        int res1 = 0, res2 = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (i > 0 and a[i] >= a[i - 1]) {
                    res1 += a[i] - a[i - 1] + 1;
                    a[i] = a[i - 1] - 1;
                }
                if (i < n - 1 and a[i] >= a[i + 1]) {
                    res1 += a[i] - a[i + 1] + 1;
                    a[i] = a[i + 1] - 1;
                }
            } else {
                if (i > 0 and b[i] >= b[i - 1]) {
                    res2 += b[i] - b[i - 1] + 1;
                    b[i] = b[i - 1] - 1;
                }
                if (i < n - 1 and b[i] >= b[i + 1]) {
                    res2 += b[i] - b[i + 1] + 1;
                    b[i] = b[i + 1] - 1;
                }
            }
        }
        return min(res1, res2)
    }
};