class Solution {
public:
    int countPoints(string rings) {
        
        int n = rings.length();
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            int r = 0, g = 0, b = 0;
            for (int j = 0; j < n; j += 2) {
                if (rings[j + 1] - '0' == i) {
                    if (rings[j] == 'R') r = 1;
                    else if (rings[j] == 'G') g = 1;
                    else b = 1;
                }
            }
            ans += r + g + b == 3;
        }
        return ans;
    }
};