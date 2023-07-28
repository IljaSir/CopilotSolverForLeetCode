class Solution {
public:
    int maximumScore(int a, int b, int c) {
        
        int sum = a + b + c;
        return sum - max(a, max(b, c)) - 1;
    }
};