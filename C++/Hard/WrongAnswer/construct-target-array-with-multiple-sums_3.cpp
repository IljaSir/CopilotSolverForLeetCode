class Solution {
public:
    bool isPossible(vector<int>& target) {
        
        priority_queue<int> q;
        long sum = 0;
        for (int i = 0; i < target.size(); i++) {
            q.push(target[i]);
            sum += target[i];
        }
        while (q.top() != 1) {
            int cur = q.top(); q.pop();
            sum -= cur;
            if (cur <= sum || sum < 1) {
                return false;
            }
            cur %= sum;
            sum += cur;
            q.push(cur);
        }
        return true;
    }
};