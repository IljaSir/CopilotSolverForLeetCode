class Solution {
public:
    int maximumScore(int a, int b, int c) {
        
        int ans = 0;
        while (true) {
            if (a == 0 || b == 0 || c == 0) break;
            if (a > b) swap(a, b);
            if (b > c) swap(b, c);
            if (a > b) swap(a, b);
            if (b == 0) break;
            a--;
            b--;
            c--;
            ans++;
        }
        return ans;
    }
};