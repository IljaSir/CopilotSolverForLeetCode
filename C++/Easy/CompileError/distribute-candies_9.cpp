class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        
        int n = candyType.size();
        unordered_set<int> s;
        for (auto x: candyType) s.insert(x);
        return min(s.size(), n/2);
    }
};