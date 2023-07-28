class Solution {
public:
    int fillCups(vector<int>& amount) {
        
        int a = amount[0], b = amount[1], c = amount[2];
        int ans = 0;
        while (a > 0 || b > 0 || c > 0) {
            if (a > 0 && b > 0 && c > 0) {
                a--, b--, c--, ans += 2;
            } else if (a > 0 && b > 0) {
                a--, b--, ans += 1;
            } else if (b > 0 && c > 0) {
                b--, c--, ans += 1;
            } else if (a > 0 && c > 0) {
                a--, c--, ans += 1;
            } else {
                ans += a + b + c;
                break;
            }
        }
        return ans;
    }
};