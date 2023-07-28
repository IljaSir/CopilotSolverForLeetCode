class Solution {
public:
    int minimumBoxes(int n) {
        
        long long sum = 0;
        long long i = 1;
        while (sum < n) {
            sum += i * (i + 1) / 2;
            i++;
        }
        i--;
        sum -= i * (i + 1) / 2;
        long long j = 1;
        while (sum < n) {
            sum += j;
            j++;
        }
        return i * (i + 1) / 2 + j - 1;
    }
};