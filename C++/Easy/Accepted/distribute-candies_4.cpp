class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        
        unordered_set<int> s;
        for (auto c : candyType) {
            s.insert(c);
        }
        return min(s.size(), candyType.size() / 2);
    }
};