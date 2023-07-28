class Solution {
public:
    int countCollisions(string directions) {
        
        int n = directions.size();
        int left = 0, right = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (directions[i] == 'L') {
                left++;
            } else if (directions[i] == 'R') {
                right++;
                ans += left;
            } else {
                ans += left;
            }
        }
        return ans;
    }
};