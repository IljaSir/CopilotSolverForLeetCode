class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        
        vector<int> ans;
        int level = 0;
        while ((1 << level) <= label) level++;
        int n = 1 << level;
        int m = 1 << (level - 1);
        while (label != 1) {
            ans.push_back(label);
            label = n - label / 2 - 1;
            n = m;
            m >>= 1;
        }
        ans.push_back(1);
        reverse(ans.begin(), ans.end());
        return ans;
    }
};