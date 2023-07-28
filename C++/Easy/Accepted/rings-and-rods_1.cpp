class Solution {
public:
    int countPoints(string rings) {
        
        int n = rings.size();
        vector<int> r(10, 0), g(10, 0), b(10, 0);
        for (int i = 0; i < n; i += 2) {
            switch (rings[i]) {
            case 'R':
                r[rings[i + 1] - '0']++;
                break;
            case 'G':
                g[rings[i + 1] - '0']++;
                break;
            case 'B':
                b[rings[i + 1] - '0']++;
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; ++i) {
            if (r[i] && g[i] && b[i]) {
                ans++;
            }
        }
        return ans;
    }
};