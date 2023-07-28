class Solution {
public:
    int countCollisions(string directions) {
        
        int n = directions.size();
        int ans = 0;
        int l = 0, r = 0;
        for (int i = 0; i < n; ++i) {
            if (directions[i] == 'L') {
                l++;
            } else if (directions[i] == 'R') {
                r++;
            } else {
                ans += l + r;
                l = 0;
                r = 0;
            }
        }
        return ans;
    }
};