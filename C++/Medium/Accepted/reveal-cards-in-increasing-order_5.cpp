class Solution {
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        
        sort(deck.begin(), deck.end());
        deque<int> q;
        for (int i = deck.size() - 1; i >= 0; --i) {
            if (q.size() > 0) {
                q.push_front(q.back());
                q.pop_back();
            }
            q.push_front(deck[i]);
        }
        vector<int> ans(q.begin(), q.end());
        return ans;
    }
};