class Solution {
public:
    bool isPossible(vector<int>& target) {
        
        priority_queue<int> pq;
        long long sum = 0;
        for(int i = 0; i < target.size(); i++){
            pq.push(target[i]);
            sum += target[i];
        }
        while(pq.top() != 1){
            int x = pq.top();
            pq.pop();
            sum -= x;
            if(x <= sum || sum < 1) return false;
            x %= sum;
            sum += x;
            pq.push(x ? x : sum);
        }
        return true;
    }
};