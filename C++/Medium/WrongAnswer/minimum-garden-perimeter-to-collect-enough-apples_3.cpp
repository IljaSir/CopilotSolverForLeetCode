class Solution {
public:
    long long minimumPerimeter(long long neededApples) {
        
        long long sum = 0;
        long long i = 1;
        while (sum < neededApples) {
            sum += 16 * i * i;
            i++;
        }
        return 8 * (i - 1);
    }
};