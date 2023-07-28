class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        
        int n = fruits.size();
        int ans = 0;
        int i = startPos;
        int j = startPos;
        int cnt = 0;
        int sum = 0;
        int type1 = fruits[startPos][0];
        int type2 = -1;
        while (i >= 0 && j < n && k >= 0) {
            if (fruits[i][0] == type1 || fruits[i][0] == type2) {
                sum += fruits[i][1];
                cnt++;
                i--;
            }
            else if (fruits[j][0] == type1 || fruits[j][0] == type2) {
                sum += fruits[j][1];
                cnt++;
                j++;
            }
            else {
                if (k > 0) {
                    k--;
                    if (type2 == -1) {
                        sum += fruits[i][1];
                        cnt++;
                        type2 = fruits[i][0];
                        i--;
                    }
                    else {
                        sum += fruits[j][1];
                        cnt++;
                        type2 = fruits[j][0];
                        j++;
                    }
                }
                else {
                    break;
                }
            }
            ans = max(ans, sum);
        }
        return ans;
    }
    int totalFruit(vector<vector<int>>& fruits, int startPos, int k) {
        int n = fruits.size();
        int ans = 0;
        int i = startPos;
        int j = startPos;
        int cnt = 0;
        int sum = 0;
        int type1 = fruits[startPos][0];
        int type2 = -1;
        while (i >= 0 && j < n && k >= 0) {
            if (fruits[i][0] == type1 || fruits[i][0] == type2) {
                sum += fruits[i][1];
                cnt++;
                i--;
            }
            else if (fruits[j][0] == type1 || fruits[j][0] == type2) {
                sum += fruits[j][1];
                cnt++;
                j++;
            }
            else {
                if (k > 0) {
                    k--;
                    if (type2 == -1) {
                        sum += fruits[i][1];
                        cnt++;
                        type2 = fruits[i][0];
                        i--;
                    }
                    else {
                        sum += fruits[j][1];
                        cnt
    }
};