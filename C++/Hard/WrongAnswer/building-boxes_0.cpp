class Solution {
public:
    int minimumBoxes(int n) {
        
        int sum = 0;
        int i = 0;
        while (sum < n) {
            ++i;
            sum += i * (i + 1) / 2;
        }
        while (sum > n) {
            sum -= i;
            --i;
        }
        return i * (i + 1) / 2;
    }
};