class Solution {
public:
    int numberOfCuts(int n) {
        
        int res = 0;
        while (n > 2) {
            res++;
            n = (n + 1) / 2;
        }
        return res;
    }
};