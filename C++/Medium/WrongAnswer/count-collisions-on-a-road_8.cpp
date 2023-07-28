class Solution {
public:
    int countCollisions(string directions) {
        
        int n = directions.size();
        int l = 0, r = n - 1;
        int ans = 0;
        while (l < r) {
            if (directions[l] == 'R' && directions[r] == 'L') {
                ans += 2;
                l++;
                r--;
            } else if (directions[l] == 'R' && directions[r] == 'R') {
                r--;
            } else if (directions[l] == 'L' && directions[r] == 'L') {
                l++;
            } else if (directions[l] == 'L' && directions[r] == 'R') {
                l++;
                r--;
            } else if (directions[l] == 'L' && directions[r] == 'S') {
                l++;
            } else if (directions[l] == 'R' && directions[r] == 'S') {
                r--;
            } else if (directions[l] == 'S' && directions[r] == 'R') {
                r--;
            } else if (directions[l] == 'S' && directions[r] == 'L') {
                l++;
            } else {
                l++;
                r--;
            }
        }
        return ans;
    }
};