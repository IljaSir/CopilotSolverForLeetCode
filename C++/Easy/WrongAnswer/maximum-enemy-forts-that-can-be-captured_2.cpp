class Solution {
public:
    int captureForts(vector<int>& forts) {
        
        int n = forts.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (i == 0) {
                left[i] = forts[i] == 1 ? 0 : -1;
            } else {
                if (forts[i] == 0) {
                    left[i] = -1;
                } else if (forts[i] == 1) {
                    left[i] = 0;
                } else {
                    if (left[i - 1] != -1) {
                        left[i] = left[i - 1] + 1;
                    } else {
                        left[i] = -1;
                    }
                }
            }
            if (j == n - 1) {
                right[j] = forts[j] == 1 ? 0 : -1;
            } else {
                if (forts[j] == 0) {
                    right[j] = -1;
                } else if (forts[j] == 1) {
                    right[j] = 0;
                } else {
                    if (right[j + 1] != -1) {
                        right[j] = right[j + 1] + 1;
                    } else {
                        right[j] = -1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == -1) {
                int l = left[i];
                int r = right[i];
                if (l != -1 && r != -1) {
                    ans = max(ans, l + r + 1);
                }
            }
        }
        return ans;
    }
};