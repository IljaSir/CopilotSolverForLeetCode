class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        
        unordered_set<int> types;
        for (int i = 0; i < candyType.size(); i++) {
            types.insert(candyType[i]);
        }
        return min(candyType.size() / 2, types.size());
    }
};