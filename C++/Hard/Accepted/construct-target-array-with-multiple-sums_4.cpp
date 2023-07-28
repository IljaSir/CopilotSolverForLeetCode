class Solution {
public:
    bool isPossible(vector<int>& target) {
        
        priority_queue<int> pq(target.begin(), target.end());
        long long sum = 0;
        for (int i = 0; i < target.size(); i++) {
            sum += target[i];
        }
        while (true) {
            int cur = pq.top();
            pq.pop();
            sum -= cur;
            if (cur == 1 || sum == 1) {
                return true;
            }
            if (cur < sum || sum == 0 || cur % sum == 0) {
                return false;
            }
            cur %= sum;
            sum += cur;
            pq.push(cur);
        }
        return false;
    }
};