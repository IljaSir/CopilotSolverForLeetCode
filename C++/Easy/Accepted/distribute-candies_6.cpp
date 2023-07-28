class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        
        int n = candyType.size();
        set<int> candySet;
        for (int i = 0; i < n; i++) {
            candySet.insert(candyType[i]);
        }
        return min(n / 2, (int) candySet.size());
    }
};