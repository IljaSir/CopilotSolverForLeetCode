class Solution {
public:
    int minimumDeletions(string s) {
        
        int n = s.size();
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                a++;
            }
        }
        int ans = a;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                a--;
            } else {
                b++;
            }
            ans = min(ans, a + b);
        }
        return ans;
    }
};