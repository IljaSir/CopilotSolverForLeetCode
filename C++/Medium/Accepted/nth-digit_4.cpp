class Solution {
public:
    int findNthDigit(int n) {
        
        long long start = 1;
        long long count = 9;
        int length = 1;
        while (n > length * count) {
            n -= length * count;
            length += 1;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / length;
        string s = to_string(start);
        return s[(n - 1) % length] - '0';
    }
};