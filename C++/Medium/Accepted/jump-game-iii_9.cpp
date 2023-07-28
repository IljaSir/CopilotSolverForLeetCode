class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        
        int N = arr.size();
        vector<int> visited(N, 0);
        queue<int> q;
        q.push(start);
        while (!q.empty()) {
            int i = q.front(); q.pop();
            if (arr[i] == 0) return true;
            visited[i] = 1;
            if (i + arr[i] < N && !visited[i+arr[i]]) q.push(i+arr[i]);
            if (i - arr[i] >= 0 && !visited[i-arr[i]]) q.push(i-arr[i]);
        }
        return false;
    }
};