class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        if (k == 0) {
            return num == 0 ? 1 : -1;
        }
        if (num == 0) {
            return 0;
        }
        int numDigits = 0;
        int numCopy = num;
        while (numCopy > 0) {
            numCopy /= 10;
            numDigits++;
        }
        if (numDigits == 1) {
            return num == k ? 1 : -1;
        }
        int maxSum = 0;
        for (int i = 0; i < numDigits; i++) {
            maxSum = maxSum * 10 + 9;
        }
        // cout << numDigits << " " << maxSum << endl;
        int minNum = maxSum - num;
        int minNumDigits = 0;
        int minNumCopy = minNum;
        while (minNumCopy > 0) {
            minNumCopy /= 10;
            minNumDigits++;
        }
        // cout << minNum << " " << minNumDigits << endl;
        if (minNumDigits == numDigits) {
            return minNum % 10 == k ? 1 : -1;
        }
        int minNumUnitsDigit = minNum % 10;
        if (minNumUnitsDigit == k) {
            return numDigits - minNumDigits + 1;
        } else if (minNumUnitsDigit > k) {
            return numDigits - minNumDigits;
        } else {
            return numDigits - minNumDigits + 1;
        }
    }
    int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    int sumOfNumbersWithUnitsDigitK(int num, int k) {
        int minNum = minimumNumbers(num, k);
        if (minNum < 0) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < minNum; i++) {
            sum += k;
        }
        return sumOfDigits(sum);
    }
};