class Solution {
public:
    int numTeams(vector<int>& rating) {
        
        int n = rating.size();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int leftBig = 0, leftSmall = 0, rightBig = 0, rightSmall = 0;
            for (int j = 0; j < i; ++j) {
                if (rating[j] > rating[i]) leftBig++;
                if (rating[j] < rating[i]) leftSmall++;
            }
            for (int j = i + 1; j < n; ++j) {
                if (rating[j] > rating[i]) rightBig++;
                if (rating[j] < rating[i]) rightSmall++;
            }
            res += leftBig * rightSmall + leftSmall * rightBig;
        }
        return res;
    }
};