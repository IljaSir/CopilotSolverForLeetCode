class Solution {
public:
    int minOperations(int n) {
        
        int cnt = 0;
        for (int i = 0; i < n / 2; i++) {
            cnt += n - (i * 2 + 1);
        }
        return cnt;
    }
};