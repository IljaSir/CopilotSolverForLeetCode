class Solution {
public:
    int checkRecord(int n) {
        
        int MOD = 1000000007;
        long long P[2], L[3], A[2];
        P[0] = L[0] = A[0] = 1;
        P[1] = L[1] = A[1] = 0;
        for(int i=2; i<=n; i++) {
            P[i%2] = ((P[(i-1)%2] + L[(i-1)%2])%MOD + A[(i-1)%2])%MOD;
            L[i%2] = (P[(i-1)%2] + P[(i-2)%2])%MOD;
            A[i%2] = ((P[(i-1)%2] + L[(i-1)%2])%MOD + A[(i-1)%2])%MOD;
        }
        return (P[n%2] + L[n%2] + A[n%2])%MOD;
    }
};