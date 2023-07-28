class Solution {
public:
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        
        unordered_set<int> s;
        s.insert(dist(p1, p2));
        s.insert(dist(p1, p3));
        s.insert(dist(p1, p4));
        s.insert(dist(p2, p3));
        s.insert(dist(p2, p4));
        s.insert(dist(p3, p4));
        return !s.count(0) && s.size() == 2;
    }
};