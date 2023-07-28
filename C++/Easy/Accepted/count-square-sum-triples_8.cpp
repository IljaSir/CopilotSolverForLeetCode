class Solution {
public:
    int countTriples(int n) {
        
        int ans = 0;
        for (int i=1;i<=n;i++) {
            for (int j=i;j<=n;j++) {
                int k = i*i + j*j;
                int m = sqrt(k);
                if (m*m == k && m <= n) {
                    ans += 2;
                }
            }
        }
        return ans;
    }
};