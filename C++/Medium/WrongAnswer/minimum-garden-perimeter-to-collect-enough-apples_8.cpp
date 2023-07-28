class Solution {
public:
    long long minimumPerimeter(long long neededApples) {
        
        long long n = 1;
        while (true) {
            long long apples = 0;
            for (int i = 0; i < n; ++i) {
                apples += (n - i) * (n - i) * 4;
            }
            if (apples >= neededApples) {
                return n * 8;
            }
            n++;
        }
        return n * 8;
    }
};