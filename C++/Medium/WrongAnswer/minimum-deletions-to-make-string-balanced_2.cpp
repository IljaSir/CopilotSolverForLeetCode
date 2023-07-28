class Solution {
public:
    int minimumDeletions(string s) {
        
        int a = 0;
        int b = 0;
        for (char c : s) {
            if (c == 'a') {
                a++;
            } else {
                b = min(a, b + 1);
            }
        }
        return b;
    }
};