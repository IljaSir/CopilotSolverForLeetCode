class Solution {
public:
    string getPermutation(int n, int k) {
        
        string result = "";
        vector<int> nums(n);
        int i, j, t, f = 1;
        for (i = 0; i < n; i++) {
            nums[i] = i + 1;
            f *= i + 1;
        }
        for (i = 0; i < n; i++) {
            f /= n - i;
            t = (k - 1) / f;
            k = k - t * f;
            result += to_string(nums[t]);
            for (j = t; j < n - i - 1; j++) {
                nums[j] = nums[j + 1];
            }
        }
        return result;
    }
};