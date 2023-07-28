class Solution {
public:
    int minMaxDifference(int num) {
        
        int digits[10] = {0};
        int n = num;
        while (n) {
            digits[n%10]++;
            n /= 10;
        }
        int minNum = 0, maxNum = 0;
        for (int i = 0; i < 10; i++) {
            if (digits[i]) {
                minNum = i;
                break;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (digits[i]) {
                maxNum = i;
                break;
            }
        }
        if (minNum == maxNum) return 0;
        int minNum2 = minNum;
        int maxNum2 = maxNum;
        for (int i = 0; i < 10; i++) {
            if (digits[i] == 0) continue;
            if (minNum2 == minNum) minNum2 = i;
            if (maxNum2 == maxNum) maxNum2 = i;
        }
        int minNum3 = minNum;
        int maxNum3 = maxNum;
        for (int i = 9; i >= 0; i--) {
            if (digits[i] == 0) continue;
            if (minNum3 == minNum) minNum3 = i;
            if (maxNum3 == maxNum) maxNum3 = i;
        }
        int minNum4 = minNum;
        int maxNum4 = maxNum;
        for (int i = 9; i >= 0; i--) {
            if (digits[i] == 0) continue;
            if (minNum4 == minNum) minNum4 = i;
            if (maxNum4 == maxNum) maxNum4 = i;
        }
        int minNum5 = minNum;
        int maxNum5 = maxNum;
        for (int i = 0; i < 10; i++) {
            if (digits[i] == 0) continue;
            if (minNum5 == minNum) minNum5 = i;
            if (maxNum5 == maxNum) maxNum5 = i;
        }
        int minNum6 = minNum;
        int maxNum6 = maxNum;
        for (int i = 0; i < 10; i++) {
            if (
    }
};