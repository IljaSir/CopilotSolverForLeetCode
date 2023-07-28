class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        
        queue<int> q;
        q.push(start);
        while (!q.empty()) {
            int i = q.front();
            q.pop();
            if (arr[i] == 0) return true;
            if (arr[i] < 0) continue;
            if (i + arr[i] < arr.size()) q.push(i + arr[i]);
            if (i - arr[i] >= 0) q.push(i - arr[i]);
            arr[i] = -arr[i];
        }
        return false;
    }
};