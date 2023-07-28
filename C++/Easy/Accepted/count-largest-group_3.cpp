class Solution {
public:
    int countLargestGroup(int n) {
        
        vector<int> counts(37, 0);
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            counts[sum]++;
        }
        int maxCount = *max_element(counts.begin(), counts.end());
        int count = 0;
        for (auto c : counts) {
            if (c == maxCount) {
                count++;
            }
        }
        return count;
    }
};