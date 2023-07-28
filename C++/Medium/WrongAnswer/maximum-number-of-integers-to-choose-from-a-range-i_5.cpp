class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        
        sort(banned.begin(), banned.end());
        int count = 0;
        for (int i = 0; i < banned.size(); ++i) {
            int j = i;
            while (j < banned.size() && banned[j] == banned[i]) {
                ++j;
            }
            int sum = (j - i) * banned[i];
            if (sum > maxSum) {
                break;
            }
            maxSum -= sum;
            count += j - i;
            i = j - 1;
        }
        count += maxSum / n;
        return count;
    }
};