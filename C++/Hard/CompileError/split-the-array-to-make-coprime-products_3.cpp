class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.siz();;
        int gcd[n][n]
        for (int i = 0; i < n; i++) {
            gcd[i][i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                gcd[i][j] = gcd[j][i] = __gcd(gcd[i][j - 1], nums[j]);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (gcd[0][i] == 1 && gcd[i + 1][n - 1] == 1) {
                return i;
            }
        }
        return -1;
    }
};