class Solution {
public:
    int superpalindromesInRange(string left, string right) {
        
        // 1 <= left.length, right.length <= 18
        // left and right cannot have leading zeros.
        // left and right represent integers in the range [1, 10^18 - 1].
        // left is less than or equal to right.
        long long l = stoll(left);
        long long r = stoll(right);
        int count = 0;
        for (long long i = 1; i * i <= r; i++) {
            long long p = i * i;
            if (p >= l && isPalindrome(p) && isPalindrome(i)) {
                count++;
            }
            long long j = i;
            long long q = j * 10;
            while (j > 0) {
                q += j % 10;
                j /= 10;
                p = q * q;
                if (p >= l && p <= r && isPalindrome(p)) {
                    count++;
                }
            }
        }
        return count;
    }
    bool isPalindrome(long long x) {
        long long y = 0;
        long long t = x;
        while (t > 0) {
            y = y * 10 + t % 10;
            t /= 10;
        }
        return x == y;
    }
};