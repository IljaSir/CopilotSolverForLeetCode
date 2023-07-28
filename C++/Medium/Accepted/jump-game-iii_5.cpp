class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        
        int n = arr.size();
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(start);
        visited[start] = true;
        while (!q.empty()) {
            int i = q.front();
            q.pop();
            if (arr[i] == 0) return true;
            if (i + arr[i] < n && !visited[i + arr[i]]) {
                q.push(i + arr[i]);
                visited[i + arr[i]] = true;
            }
            if (i - arr[i] >= 0 && !visited[i - arr[i]]) {
                q.push(i - arr[i]);
                visited[i - arr[i]] = true;
            }
        }
        return false;
    }
};