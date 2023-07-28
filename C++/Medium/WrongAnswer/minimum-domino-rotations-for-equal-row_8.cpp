class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        
        int n = tops.size();
        int c1 = 0, c2 = 0, t = tops[0], b = bottoms[0];
        for(int i = 0; i < n; i++) {
            if(tops[i] != t && bottoms[i] != t) t = -1;
            if(tops[i] != b && bottoms[i] != b) b = -1;
            if(t == -1 && b == -1) return -1;
        }
        for(int i = 0; i < n; i++) {
            if(tops[i] != t) c1++;
            if(bottoms[i] != t) c1++;
            if(tops[i] != b) c2++;
            if(bottoms[i] != b) c2++;
        }
        return min(c1, c2)/2;
    }
};