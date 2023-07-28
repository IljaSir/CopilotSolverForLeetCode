class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        
        int n = piles.size();
        int m = piles[0].size();
        sort(piles.begin(), piles.end());
        int i = 0;
        int j = m - 1;
        int sum = 0;
        while (k > 0) {
            sum += piles[i][j];
            j--;
            k--;
            if (k > 0) {
                sum += piles[n - i - 1][j];
                j--;
                k--;
            }
            if (j < 0) {
                i++;
                j = m - 1;
            }
        }
        return sum;
    }
};