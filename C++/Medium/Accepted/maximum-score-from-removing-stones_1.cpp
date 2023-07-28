class Solution {
public:
    int maximumScore(int a, int b, int c) {
        
        if (a < b) {
            swap(a, b);
        }
        if (a < c) {
            swap(a, c);
        }
        if (b < c) {
            swap(b, c);
        }
        if (a <= b + c) {
            return (a + b + c) / 2;
        } else {
            return b + c;
        }
    }
};