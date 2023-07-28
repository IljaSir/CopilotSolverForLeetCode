class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        
        int n = tops.size();
        for (int i = 1; i < n; i++)
            if (tops[i] != tops[0] && bottoms[i] != tops[0])
                tops[i] = -1;
        for (int i = 1; i < n; i++)
            if (bottoms[i] != bottoms[0] && tops[i] != bottoms[0])
                bottoms[i] = -1;
        int res = 0;
        for (int i = 0; i < n; i++)
            if (tops[i] != bottoms[0]) {
                res = -1;
                break;
            }
        if (res != -1)
            return res;
        res = 0;
        for (int i = 0; i < n; i++)
            if (bottoms[i] != tops[0]) {
                res = -1;
                break;
            }
        if (res != -1)
            return res;
        res = 0;
        for (int i = 0; i < n; i++)
            if (tops[i] == -1) {
                res = -1;
                break;
            }
        if (res != -1)
            return res;
        res = 0;
        for (int i = 0; i < n; i++)
            if (bottoms[i] == -1) {
                res = -1;
                break;
            }
        if (res != -1)
            return res;
        res = 0;
        for (int i = 0; i < n; i++)
            if (tops[i] == bottoms[0])
                res++;
        return n - res;
    }
};