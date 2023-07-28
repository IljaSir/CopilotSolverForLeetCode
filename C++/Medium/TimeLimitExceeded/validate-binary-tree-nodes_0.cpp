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
                if (root == -1) {
                    root = i;
                } else {
                    return false;
                }
            }
        }
        if (root == -1) return false;
        queue<int> q;
        q.push(root);
        int count = 0;
        while (!q.empty()) {
            int cur = q.front(); q.pop();
            count++;
            if (leftChild[cur] != -1) q.push(leftChild[cur]);
            if (rightChild[cur] != -1) q.push(rightChild[cur]);
        }
        return count == n;
    }
};