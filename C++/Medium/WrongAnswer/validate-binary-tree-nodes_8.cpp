class Solution {
public:
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        
        unordered_set<int> s;
        for (int i = 0; i < n; ++i) {
            if (leftChild[i] != -1) {
                if (s.count(leftChild[i])) return false;
                s.insert(leftChild[i]);
            }
            if (rightChild[i] != -1) {
                if (s.count(rightChild[i])) return false;
                s.insert(rightChild[i]);
            }
        }
        if (s.size() != n - 1) return false;
        return true;
    }
};