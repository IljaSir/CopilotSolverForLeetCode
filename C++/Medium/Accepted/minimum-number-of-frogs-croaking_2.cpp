class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int n = croakOfFrogs.size();
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (croakOfFrogs[i] == 'c') {
                c++;
            } else if (croakOfFrogs[i] == 'r') {
                r++;
            } else if (croakOfFrogs[i] == 'o') {
                o++;
            } else if (croakOfFrogs[i] == 'a') {
                a++;
            } else if (croakOfFrogs[i] == 'k') {
                k++;
            }
            if (c < r || r < o || o < a || a < k) {
                return -1;
            }
            ans = max(ans, c - k);
        }
        if (c != r || r != o || o != a || a != k) {
            return -1;
        }
        return ans;
    }
};