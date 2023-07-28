class Solution {
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        
        int n = deck.size();
        if (n <= 1) return deck;
        sort(deck.begin(), deck.end());
        deque<int> dq;
        dq.push_back(deck[n-1]);
        for (int i = n-2; i >= 0; i--) {
            int t = dq.back();
            dq.pop_back();
            dq.push_front(t);
            dq.push_front(deck[i]);
        }
        vector<int> res;
        while (!dq.empty()) {
            res.push_back(dq.front());
            dq.pop_front();
        }
        return res;
    }
};