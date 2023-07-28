class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        
        int m = quantities.size();
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += quantities[i];
        }
        int l = 1, r = sum;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int count = 0;
            for (int i = 0; i < m; i++) {
                count += quantities[i] / mid;
            }
            if (count < n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
};