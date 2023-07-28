class Solution {
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        
        sort(deck.begin(), deck.end());
        vector<int> res(deck.size());
        int pos = 0;
        for (int i = 0; i < deck.size(); i++) {
            res[pos] = deck[i];
            pos = (pos + 2) % deck.size();
            while (res[pos] != 0) {
                pos = (pos + 1) % deck.size();
            }
        }
        return res;
    }
};