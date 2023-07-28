class Solution {
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        
        sort(deck.begin(), deck.end());
        vector<int> ans(deck.size(), 0);
        int i = 0, j = 0;
        while (i < deck.size()) {
            if (ans[j] == 0) {
                ans[j] = deck[i];
                i++;
            }
            j = (j + 1) % deck.size();
        }
        return ans;
    }
};