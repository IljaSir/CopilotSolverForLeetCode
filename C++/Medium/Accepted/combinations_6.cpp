class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        
        vector<vector<int>> result;
        vector<int> temp;
        for (int i = 1; i <= k; i++) {
            temp.push_back(i);
        }
        result.push_back(temp);
        while (true) {
            if (temp[0] == n - k + 1) {
                break;
            }
            int i = k - 1;
            while (i >= 0 && temp[i] == n - k + i + 1) {
                i--;
            }
            temp[i]++;
            for (int j = i + 1; j < k; j++) {
                temp[j] = temp[j - 1] + 1;
            }
            result.push_back(temp);
        }
        return result;
    }
};