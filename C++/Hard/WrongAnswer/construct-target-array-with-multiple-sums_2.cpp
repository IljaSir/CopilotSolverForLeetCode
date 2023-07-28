class Solution {
public:
    bool isPossible(vector<int>& target) {
        
        int n = target.size();
        priority_queue<int> pq;
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += target[i];
            pq.push(target[i]);
        }
        while (pq.top() > 1) {
            int val = pq.top();
            pq.pop();
            sum -= val;
            if (val <= sum || sum < 1) return false;
            val %= sum;
            sum += val;
            pq.push(val);
        }
        return true;
    }
};