class Solution {
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        
        sort(deck.begin(), deck.end());
        deque<int> dq;
        dq.push_back(deck.back());
        for (int i = deck.size() - 2; i >= 0; i--) {
            dq.push_front(dq.back());
            dq.pop_back();
            dq.push_front(deck[i]);
        }
        return vector<int>(dq.begin(), dq.end());
    }
};