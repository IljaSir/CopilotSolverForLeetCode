class Solution {
public:
    int countLargestGroup(int n) {
        
        int cnt[37] = {0};
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while (num) {
                sum += num % 10;
                num /= 10;
            }
            cnt[sum]++;
        }
        int max = 0;
        int maxcnt = 0;
        for (int i = 1; i <= 36; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                maxcnt = 1;
            } else if (cnt[i] == max) {
                maxcnt++;
            }
        }
        return maxcnt;
    }
};