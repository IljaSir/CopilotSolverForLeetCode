class Solution {
public:
    bool isPossible(vector<int>& target) {
        
        if (target.size() == 1 && target[0] == 1)
            return true;
        
        priority_queue<int> pq;
        long long sum = 0;
        for (int i = 0; i < target.size(); i++) {
            sum += target[i];
            pq.push(target[i]);
        }
        
        while (pq.top() != 1) {
            int x = pq.top();
            pq.pop();
            sum -= x;
            if (x <= sum || sum < 1)
                return false;
            
            x %= sum;
            sum += x;
            if (x == 0)
                x = sum;
            
            pq.push(x);
        }
        
        return true;
    }
};