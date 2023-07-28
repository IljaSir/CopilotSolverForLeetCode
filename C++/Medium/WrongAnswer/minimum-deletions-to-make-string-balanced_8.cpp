class Solution {
public:
    int minimumDeletions(string s) {
        
        int n = s.size();
        int a = 0, b = 0;
        for (char c : s) {
            if (c == 'b') b++;
        }
        int ans = b;
        for (char c : s) {
            if (c == 'a') a++;
            else b--;
            ans = min(ans, a + b);
        }
        return ans;
    }
};