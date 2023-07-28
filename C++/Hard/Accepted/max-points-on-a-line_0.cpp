class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        if (n < 3) return n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map<pair<int, int>, int> mp;
            int same = 0;
            int maxn = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                if (dx == 0 && dy == 0) {
                    same++;
                    continue;
                }
                int d = gcd(dx, dy);
                dx /= d;
                dy /= d;
                mp[make_pair(dx, dy)]++;
                maxn = max(maxn, mp[make_pair(dx, dy)]);
            }
            ans = max(ans, maxn + same + 1);
        }
        return ans;
    }
    int gcd(int a, int b) {
        return b ? gcd(b, a % b) : a;
    }
};