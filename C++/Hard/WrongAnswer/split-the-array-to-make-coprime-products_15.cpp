class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> gcds(n);
        gcds[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; --i) {
            gcds[i] = gcd(gcds[i+1], nums[i]);
        }
        if (gcds[0] == 1) return 0;
        int prod = 1;
        for (int i = 0; i < n; ++i) {
            prod = (long long)prod * nums[i] % 1000000007;
            if (prod == 1) return i;
            if (gcd(prod, gcds[i+1]) == 1) return i;
        }
        return -1;
    }
    int gcd(int a, int b) {
        if (a < b) swap(a, b);
        while (b) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
};