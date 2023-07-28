class Solution {
public:
    int numberOfCuts(int n) {
        
        if (n <= 2) return 1;
        return numberOfCuts(n - 1) + n - 1;
    }
};