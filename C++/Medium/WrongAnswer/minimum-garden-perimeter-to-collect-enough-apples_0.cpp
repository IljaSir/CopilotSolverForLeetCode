class Solution {
public:
    long long minimumPerimeter(long long neededApples) {
        
        long long left = 0, right = 100000;
        while (left < right) {
            long long mid = left + (right - left) / 2;
            if (check(mid, neededApples)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left * 4;
    }
    bool check(long long mid, long long neededApples) {
        long long sum = 0;
        for (long long i = 0; i <= mid; ++i) {
            sum += (mid - i + 1) * (mid - i + 1) * 2 + (mid - i) * (mid - i) * 2;
        }
        return sum >= neededApples;
    }
};