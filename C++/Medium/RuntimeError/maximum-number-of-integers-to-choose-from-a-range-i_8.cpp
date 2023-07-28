class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        
        sort(banned.begin(), banned.end());
        banned.push_back(n+1);
        int res = 0;
        for (int i = 0; i < banned.size(); ++i) {
            int j = i + 1;
            while (j < banned.size() && banned[j] == banned[i]) ++j;
            int x = banned[i] - banned[i-1] - 1;
            int y = maxSum - (banned[i] - 1) * (j - i);
            if (x <= y) {
                res += x;
                maxSum -= (banned[i] - banned[i-1] - 1) * (j - i);
            } else {
                res += y;
                break;
            }
            i = j - 1;
        }
        return res;
    }
};