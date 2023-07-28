class Solution {
public:
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        
        return isSquare(p1, p2, p3, p4) || isSquare(p1, p2, p4, p3) || isSquare(p1, p3, p2, p4) || isSquare(p1, p3, p4, p2) || isSquare(p1, p4, p2, p3) || isSquare(p1, p4, p3, p2);
    }
};