class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        
        priority_queue<int> q;
        for (auto i: stones) q.push(i);
        while (q.size() > 1) {
            auto x = q.top(); q.pop();
            auto y = q.top(); q.pop();
            if (x != y) q.push(x - y);
        }
        return q.empty() ? 0 : q.top();
    }
};