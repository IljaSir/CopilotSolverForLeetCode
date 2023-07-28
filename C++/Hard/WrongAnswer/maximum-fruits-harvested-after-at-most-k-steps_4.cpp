class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        
        int n = fruits.size();
        int l = startPos;
        int r = startPos;
        int total = 0;
        int ans = 0;
        int i = startPos;
        int j = startPos;
        while (i >= 0 && j < n) {
            if (fruits[i][0] >= fruits[startPos][0] - k) {
                total += fruits[i][1];
                i--;
            } else if (fruits[j][0] <= fruits[startPos][0] + k) {
                total += fruits[j][1];
                j++;
            } else {
                break;
            }
            ans = max(ans, total);
        }
        return ans;
    }
    int totalFruit(vector<int>& tree) {
        int n = tree.size();
        vector<vector<int>> fruits;
        int last = tree[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (tree[i] == last) {
                count++;
            } else {
                fruits.push_back({i - count, count});
                last = tree[i];
                count = 1;
            }
        }
        fruits.push_back({n - count, count});
        int ans = 0;
        for (int i = 0; i < fruits.size(); i++) {
            ans = max(ans, maxTotalFruits(fruits, i, n));
        }
        return ans;
    }
};