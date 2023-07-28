class Solution {
public:
    int minimumBuckets(string hamsters) {
        
        int n = hamsters.size();
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters[i] == 'H') {
                if (i == 0 || hamsters[i - 1] == '.') {
                    left++;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (hamsters[i] == 'H') {
                if (i == n - 1 || hamsters[i + 1] == '.') {
                    right++;
                }
            }
        }
        if (right == 0 || left == 0) {
            return -1;
        }
        return max(left, right);
    }
};