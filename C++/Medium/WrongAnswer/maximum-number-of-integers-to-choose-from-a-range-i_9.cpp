class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        
        sort(banned.begin(), banned.end());
        int i = 0;
        int count = 0;
        int sum = 0;
        while ( i < banned.size() && sum + banned[i] - 1 <= maxSum) {
            sum += banned[i] - 1;
            count += banned[i] - 1;
            i++;
        }
        if (i < banned.size()) {
            int k = banned[i] - sum - 1;
            count += k;
            sum += k;
            int j = i;
            while (j < banned.size() && banned[j] == banned[i]) {
                j++;
            }
            i = j;
        }
        if (sum < maxSum) {
            int k = min(n - banned.back(), maxSum - sum);
            count += k;
        }
        return count;
    }
};