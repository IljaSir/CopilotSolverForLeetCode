class Solution {
public:
    long long minimumPerimeter(long long neededApples) {
        
        long long n = 1;
        while (n * (n + 1) * (2 * n + 1) < 12 * neededApples) {
            ++n;
        }
        return 8 * n;
    }
};