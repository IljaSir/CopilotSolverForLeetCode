class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
        
        int n = candyType.size();
        unordered_set<int> candy(candyType.begin(), candyType.end());
        return min(n/2, candy.size());
    }
};