class Solution {
public:
    long long minimumPerimeter(long long neededApples) {
        
        long long l = 0, r = 1e9, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (m * (m + 1) * (m + m + 1) / 6 >= neededApples) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (l + l + l) * 2;
    }
};