class Solution {
public:
    int passThePillow(int n, int time) {
        
        int i = 0;
        while (time--) {
            if (i == 0 || i == n - 1) {
                i = n - i - 1;
            } else {
                i = n - i - 2;
            }
        }
        return i + 1;
    }
};