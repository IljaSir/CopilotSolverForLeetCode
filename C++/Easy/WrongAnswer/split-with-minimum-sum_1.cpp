class Solution {
public:
    int splitNum(int num) {
        
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    int splitNum2(int num) {
        int sum = 0;
        int cnt[10] = {0};
        while (num > 0) {
            cnt[num % 10]++;
            num /= 10;
        }
        for (int i = 0; i < 10; i++) {
            sum += i * cnt[i];
        }
        return sum;
    }
    int splitNum3(int num) {
        int sum = 0;
        int cnt[10] = {0};
        while (num > 0) {
            cnt[num % 10]++;
            num /= 10;
        }
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] > 0) {
                sum += i * cnt[i];
                cnt[i]--;
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            sum += i * cnt[i];
        }
        return sum;
    }
    int splitNum4(int num) {
        int sum = 0;
        int cnt[10] = {0};
        while (num > 0) {
            cnt[num % 10]++;
            num /= 10;
        }
        int idx = 0;
        while (cnt[idx] == 0) {
            idx++;
        }
        cnt[idx]--;
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] > 0) {
                sum += i * cnt[i];
                cnt[i]--;
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            sum += i * cnt[i];
        }
        return sum;
    }
};