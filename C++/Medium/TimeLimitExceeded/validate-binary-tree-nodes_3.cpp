class Solution {
public:
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        
        vector<int> in(n, 0);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                in[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                in[rightChild[i]]++;
            }
        }
        int root = 0;
        while (root < n && in[root] != 0) {
            root++;
        }
        if (root == n) {
            return false;
        }
        queue<int> q;
        q.push(root);
        int num = 0;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            num++;
            if (leftChild[cur] != -1) {
                q.push(leftChild[cur]);
            }
            if (rightChild[cur] != -1) {
                q.push(rightChild[cur]);
            }
        }
        return num == n;
    }
};