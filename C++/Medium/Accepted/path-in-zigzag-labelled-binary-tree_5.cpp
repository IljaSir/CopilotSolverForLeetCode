class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        
        vector<int> ans;
        int level = 0;
        int n = 1;
        while (n <= label) {
            level++;
            n *= 2;
        }
        ans.push_back(label);
        while (level > 1) {
            int min = 1 << (level - 1);
            int max = (1 << level) - 1;
            int parent = (min + max - label) / 2;
            ans.push_back(parent);
            label = parent;
            level--;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};