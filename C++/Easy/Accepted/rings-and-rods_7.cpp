class Solution {
public:
    int countPoints(string rings) {
        
        int n = rings.size();
        if (n == 2) return 0;
        int res = 0;
        for (int i = 0; i < 10; i++) {
            int r = 0, g = 0, b = 0;
            for (int j = 0; j < n; j += 2) {
                if (rings[j + 1] - '0' == i) {
                    if (rings[j] == 'R') r++;
                    else if (rings[j] == 'G') g++;
                    else b++;
                }
            }
            if (r > 0 && g > 0 && b > 0) res++;
        }
        return res;
    }
};