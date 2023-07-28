class Solution {
public:
    int nextBeautifulNumber(int n) {
        
        int x = n;
        int d = 1;
        int ans = 0;
        while(x > 0) {
            int r = x % 10;
            ans += d * (r + 1);
            d *= 10;
            x /= 10;
        }
        return ans;
    }
    int nextGreaterElement(int n) {
        int x = n;
        int d = 1;
        int ans = 0;
        while(x > 0) {
            int r = x % 10;
            ans += d * (r + 1);
            d *= 10;
            x /= 10;
        }
        return ans;
    }
};