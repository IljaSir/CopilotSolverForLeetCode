class Solution {
public:
    int countCollisions(string directions) {
        
        int n = directions.length();
        int num = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (directions[l] == 'L') {
                l++;
                continue;
            }
            if (directions[r] == 'R') {
                r--;
                continue;
            }
            if (directions[l] == 'R' && directions[r] == 'L') {
                num += 2;
                l++;
                r--;
                continue;
            }
            if (directions[l] == 'S' && directions[r] == 'S') {
                l++;
                r--;
                continue;
            }
            if (directions[l] == 'S' && directions[r] == 'L') {
                num++;
                l++;
                r--;
                continue;
            }
            if (directions[l] == 'R' && directions[r] == 'S') {
                num++;
                l++;
                r--;
                continue;
            }
        }
        return num;
    }
};