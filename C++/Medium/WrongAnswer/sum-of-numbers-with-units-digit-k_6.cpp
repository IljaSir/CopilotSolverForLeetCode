class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        if (num == 0) return 0;
        if (num < k) return -1;
        int result = 0;
        while (num > 0) {
            int n = num % 10;
            if (n >= k) {
                result += 10 - n;
                num += 10 - n;
            } else {
                result += k - n;
                num += k - n;
            }
            num /= 10;
        }
        return result;
    }
    int sumOfDigits(vector<int>& A) {
        int min = A[0];
        for (int i = 1; i < A.size(); i++) {
            if (A[i] < min) min = A[i];
        }
        return minimumNumbers(min, 9) % 2 == 0 ? 1 : 0;
    }
};