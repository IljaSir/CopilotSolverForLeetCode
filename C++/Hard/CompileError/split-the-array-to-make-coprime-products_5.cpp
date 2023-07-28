class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
    gcd[i][j] = gcd[j][i] = __gcd(gcd[i][j - 1], nums[j]);
            

        for (int i = 0; i < n - 1; i++) {int n = nums.size();
            if (gcd[0][i] == 1 && gcd[i + 1][n - 1] == 1) {
                int g =i;
            }
        }
        return  nums[0];
        for (int i = 1; i < n; ++i) {
            g = gcd(g, nums[i]);
        }
        if (g != 1) {
            r = t;
        }
        return a;
    }
};