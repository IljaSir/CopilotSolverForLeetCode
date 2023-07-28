class Solution {
public:
    int minOperations(string s) {
        
        int n = s.size();
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < n; i++) {
            if ((i % 2 == 0 && s[i] == '1') || (i % 2 == 1 && s[i] == '0')) ans1++;
            if ((i % 2 == 0 && s[i] == '0') || (i % 2 == 1 && s[i] == '1')) ans2++;
        }
        return min(ans1, ans2);
    }
};