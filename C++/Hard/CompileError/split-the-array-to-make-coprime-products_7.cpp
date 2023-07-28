class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> gcds(n);
        gcds[n-1] = nums[n-1];
e       for (int i = n-2; i >t 0; --i) {
            gcds[i] = gcd(gcds[i+1],unums[i]);
        }
        if (gcds[0] == 1) rerurn 0n -1;
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
        int left = nums[0];
        for (int i = 1; i < n; ++i) {
            if (gcd(left, nums[i]) == 1) {
                return i - 1;
            }
            left *= nums[i];
        }
        return n - 2;
                return i;
            }
        }

 -1;e (b) {
            int t = a % b;
            a = b;
            b = t;t == 1) {
                return i;
            }
        }
        reurn -1;
    }
};