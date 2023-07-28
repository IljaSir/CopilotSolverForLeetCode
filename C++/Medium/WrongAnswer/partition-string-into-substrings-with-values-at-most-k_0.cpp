class Solution {
public:
    int minimumPartition(string s, int k) {
        
        int n = s.size();
        vector<int> sum(n+1, 0);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + (s[i-1] - '0');
        }
        int minPart = n;
        for (int i = 0; i < n; i++) {
            int j = i;
            int part = 1;
            while (j < n) {
                int l = j;
                int r = n;
                while (r - l > 1) {
                    int mid = l + (r-l)/2;
                    if (sum[mid] - sum[j] <= k) {
                        l = mid;
                    } else {
                        r = mid;
                    }
                }
                if (l == j) {
                    part = -1;
                    break;
                }
                j = l;
                part++;
            }
            if (part != -1) {
                minPart = min(minPart, part);
            }
        }
        return minPart;
    }
};