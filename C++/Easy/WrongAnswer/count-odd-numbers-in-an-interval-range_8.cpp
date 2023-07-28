class Solution {
public:
    int countOdds(int low, int high) {
        
        int res = 0;
        if (low % 2 != 0 || high % 2 != 0) {
            res++;
            low++;
            high--;
        }
        return res + (high - low) / 2;
    }
};