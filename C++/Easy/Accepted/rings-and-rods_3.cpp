class Solution {
public:
    int countPoints(string rings) {
        
        int ans = 0;
        vector<int> r(10), g(10), b(10);
        for (int i = 0; i < rings.length(); i += 2) {
            if (rings[i] == 'R') {
                r[rings[i + 1] - '0']++;
            } else if (rings[i] == 'G') {
                g[rings[i + 1] - '0']++;
            } else {
                b[rings[i + 1] - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (r[i] > 0 && g[i] > 0 && b[i] > 0) {
                ans++;
            }
        }
        return ans;
    }
};