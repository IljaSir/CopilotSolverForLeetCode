class Solution {
public:
    long long minimumPerimeter(long long neededApples) {
        
        long long n = 1;
        while (n * n * (n + 1) * (n + 1) < neededApples) {
            n++;
        }
        return n * 8;
    }
};