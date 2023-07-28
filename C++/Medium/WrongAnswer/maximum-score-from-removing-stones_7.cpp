class Solution {
public:
    int maximumScore(int a, int b, int c) {
        
        if (a + b + c < 3) {
            return a + b + c;
        }
        return (a + b + c - 2) / 2;
    }
};