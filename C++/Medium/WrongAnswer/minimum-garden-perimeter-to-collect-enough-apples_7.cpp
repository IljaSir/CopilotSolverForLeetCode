class Solution {
public:
    long long minimumPerimeter(long long neededApples) {
        
        long long i = 1;
        while (true) {
            long long apples = (i * 2 + 1) * (i * 2 + 1) * (i + 1);
            if (apples >= neededApples) {
                return (i * 2 + 1) * 4;
            }
            i++;
        }
    }
};