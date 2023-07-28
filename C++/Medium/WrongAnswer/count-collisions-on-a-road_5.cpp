class Solution {
public:
    int countCollisions(string directions) {
        
        int n = directions.size();
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (directions[i] == 'L') {
                count++;
            } else if (directions[i] == 'R') {
                ans += count;
            } else {
                ans += count / 2;
                count = (count + 1) / 2;
            }
        }
        return ans;
    }
};