class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> left(n, nums[0]), right(n, nums.back());
        for (int i = 1; i < n; ++i) {
            left[i] = gcd(left[i - 1], nums[i]);
            right[n - i - 1] = gcd(right[n - i], nums[n - i - 1]);
        }
        for (int i = 0; i < n - 1; ++i) {
            if (gcd(left[i], right[i + 1]) == 1) {
                return i + 1;
            }
        }
        return -1;
    }
    
    int gcd(int a, int b) {
        while (b) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
};