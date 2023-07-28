class Solution {
public:
    int countLargestGroup(int n) {
        
        unordered_map<int, int> m;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int tmp = i;
            while (tmp) {
                sum += tmp % 10;
                tmp /= 10;
            }
            m[sum]++;
            if (m[sum] > max) {
                max = m[sum];
            }
        }
        int ret = 0;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second == max) {
                ret++;
            }
        }
        return ret;
    }
};