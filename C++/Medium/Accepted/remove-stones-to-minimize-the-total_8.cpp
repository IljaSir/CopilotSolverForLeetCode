class Solution {
public:
    int minStoneSum(vector<int>& piles, int k) {
        
        priority_queue<int> q;
        for (int x: piles) {
            q.push(x);
        }
        while (k--) {
            int top = q.top();
            q.pop();
            q.push(top - top / 2);
        }
        int res = 0;
        while (!q.empty()) {
            res += q.top();
            q.pop();
        }
        return res;
    }
};