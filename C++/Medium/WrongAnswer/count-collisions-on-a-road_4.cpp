class Solution {
public:
    int countCollisions(string directions) {
        
        int n = directions.size();
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (directions[i] == 'L') {
                cnt++;
            } else if (directions[i] == 'R') {
                ans += cnt;
            } else {
                ans += cnt & 1;
            }
        }
        return ans;
    }
};