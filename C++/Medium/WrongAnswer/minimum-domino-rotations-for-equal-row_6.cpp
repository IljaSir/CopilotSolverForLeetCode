class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        
        int n = tops.size();
        int ans = -1;
        for (int i = 1; i <= 6; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (tops[j] == i || bottoms[j] == i) {
                    cnt++;
                }
            }
            if (cnt == n) {
                int cnt1 = 0, cnt2 = 0;
                for (int j = 0; j < n; j++) {
                    if (tops[j] != i) {
                        cnt1++;
                    }
                    if (bottoms[j] != i) {
                        cnt2++;
                    }
                }
                ans = min(ans, min(cnt1, cnt2));
            }
        }
        return ans;
    }
};