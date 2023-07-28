class Solution {
public:
    int createSortedArray(vector<int>& instructions) {
        
        int n = instructions.size();
        vector<int> bit(n + 1, 0);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = instructions[i];
            res = (res + min(get(x - 1, bit), i - get(x, bit))) % 1000000007;
            update(x, bit);
        }
        return res;
    }
};