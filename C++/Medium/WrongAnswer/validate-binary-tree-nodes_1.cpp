class Solution {
public:
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        
        vector<int> indegree(n, 0);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) indegree[leftChild[i]]++;
            if (rightChild[i] != -1) indegree[rightChild[i]]++;
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (root != -1) return false;
                root = i;
            }
        }
        if (root == -1) return false;
        queue<int> q;
        q.push(root);
        while (!q.empty()) {
            int u = q.front(); q.pop();
            if (leftChild[u] != -1) {
                q.push(leftChild[u]);
            }
            if (rightChild[u] != -1) {
                q.push(rightChild[u]);
            }
        }
        return q.size() == n;
    }
};