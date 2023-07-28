class Solution {
public:
    int countLargestGroup(int n) {
        
        int count[37] = {0};
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int j = i;
            while (j) {
                sum += j % 10;
                j /= 10;
            }
            count[sum]++;
        }
        int max = 0;
        int result = 0;
        for (int i = 0; i < 37; i++) {
            if (count[i] > max) {
                max = count[i];
                result = 1;
            } else if (count[i] == max) {
                result++;
            }
        }
        return result;
    }
};