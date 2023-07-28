class Solution {
public:
    int countCollisions(string directions) {
        
        int n = directions.size();
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (directions[i] == 'R') {
                ans += count;
            } else if (directions[i] == 'L') {
                count++;
            } else {
                ans += count;
            }
        }
        return ans;
    }
};