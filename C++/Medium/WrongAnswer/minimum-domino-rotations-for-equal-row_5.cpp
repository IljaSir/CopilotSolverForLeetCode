class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        
        int n = tops.size();
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        int t1 = tops[0], t2 = bottoms[0];
        for (int i = 0; i < n; i++) {
            if (tops[i] != t1 && bottoms[i] != t1) {
                c1 = -1;
            }
            if (tops[i] != t2 && bottoms[i] != t2) {
                c2 = -1;
            }
            if (tops[i] != t1 && bottoms[i] != t1) {
                c3 = -1;
            }
            if (tops[i] != t2 && bottoms[i] != t2) {
                c4 = -1;
            }
            if (c1 != -1) {
                if (tops[i] != t1) c1++;
            }
            if (c2 != -1) {
                if (bottoms[i] != t2) c2++;
            }
            if (c3 != -1) {
                if (tops[i] != t1) c3++;
            }
            if (c4 != -1) {
                if (tops[i] != t2) c4++;
            }
        }
        int r = -1;
        if (c1 != -1) r = c1;
        if (c2 != -1) {
            if (r == -1) r = c2;
            else r = min(r, c2);
        }
        if (c3 != -1) {
            if (r == -1) r = c3;
            else r = min(r, c3);
        }
        if (c4 != -1) {
            if (r == -1) r = c4;
            else r = min(r, c4);
        }
        return r;
    }
};