class Solution {
public:
    long long minimumPerimeter(long long neededApples) {
        
        long long l = 0;
        long long r = 1000000000;
        while (l < r) {
            long long m = (l + r) / 2;
            if (m * m * 2 + m * 2 + 1 >= neededApples) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l * 8;
    }
};