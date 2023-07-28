class Solution {
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        
        sort(deck.begin(), deck.end());
        vector<int> result;
        int n = deck.size();
        result.push_back(deck[0]);
        for (int i = 1; i < n; ++i) {
            int temp = result[result.size() - 1];
            result.pop_back();
            result.insert(result.begin(), temp);
            result.insert(result.begin(), deck[i]);
        }
        return result;
    }
};