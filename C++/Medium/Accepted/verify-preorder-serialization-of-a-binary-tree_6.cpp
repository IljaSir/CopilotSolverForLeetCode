class Solution {
public:
    bool isValidSerialization(string preorder) {
        
        vector<string> nodes;
        int i = 0;
        while (i < preorder.size()) {
            int j = i;
            while (j < preorder.size() && preorder[j] != ',') {
                ++j;
            }
            string node = preorder.substr(i, j - i);
            nodes.push_back(node);
            i = j + 1;
        }
        int n = nodes.size();
        int d = 1;
        for (int i = 0; i < n; ++i) {
            --d;
            if (d < 0) {
                return false;
            }
            if (nodes[i] != "#") {
                d += 2;
            }
        }
        return d == 0;
    }
};