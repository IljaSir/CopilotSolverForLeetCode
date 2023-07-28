class Solution {
public:
    int countLargestGroup(int n) {
        
        int max_size = 0;
        int count = 0;
        unordered_map<int, int> m;
        for (int i = 1; i <= n; ++i) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            m[sum]++;
            if (m[sum] > max_size) {
                max_size = m[sum];
                count = 1;
            } else if (m[sum] == max_size) {
                count++;
            }
        }
        return count;
    }
};