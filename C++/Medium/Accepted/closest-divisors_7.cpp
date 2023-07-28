class Solution {
public:
    vector<int> closestDivisors(int num) {
        
        int a = num+1;
        int b = num+2;
        int a1 = sqrt(a);
        int a2 = sqrt(b);
        int d1 = INT_MAX;
        int d2 = INT_MAX;
        int r1 = 0;
        int r2 = 0;
        for(int i = 1; i <= a1; ++i) {
            if(a % i == 0) {
                int j = a/i;
                if(abs(i-j) < d1) {
                    d1 = abs(i-j);
                    r1 = i;
                }
            }
        }
        for(int i = 1; i <= a2; ++i) {
            if(b % i == 0) {
                int j = b/i;
                if(abs(i-j) < d2) {
                    d2 = abs(i-j);
                    r2 = i;
                }
            }
        }
        if(d1 < d2) {
            return {r1, a/r1};
        } else {
            return {r2, b/r2};
        }
    }
};