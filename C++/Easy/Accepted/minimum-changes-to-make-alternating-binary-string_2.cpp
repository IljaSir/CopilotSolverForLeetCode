class Solution {
public:
    int minOperations(string s) {
        
        int n = s.size();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] != '0' + i % 2) {
                cnt1++;
            }
            if (s[i] != '0' + (i + 1) % 2) {
                cnt2++;
            }
        }
        return min(cnt1, cnt2);
    }
};