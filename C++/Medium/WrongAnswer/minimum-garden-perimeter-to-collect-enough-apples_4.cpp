class Solution {
public:
    long long minimumPerimeter(long long neededApples) {
        
        long long n = 1;
        while (n * (n + 1) * (2 * n + 1) * (n + 2) / 24 < neededApples) {
            n++;
        }
        return n * 8;
    }
};