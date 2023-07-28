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
        int cnt = 0;
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                cnt++;
                root = i;
            }
        }
        if (cnt != 1) {
            return false;
        }
        queue<int> q;
        q.push(root);
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            if (leftChild[cur] != -1) {
                q.push(leftChild[cur]);
            }
            if (rightChild[cur] != -1) {
                q.push(rightChild[cur]);
            }
        }
        return q.size() == n;
    }
};