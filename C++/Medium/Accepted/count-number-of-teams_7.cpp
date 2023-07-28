class Solution {
public:
    int numTeams(vector<int>& rating) {
        
        int n = rating.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int leftLess = 0, leftGreater = 0, rightLess = 0, rightGreater = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftLess++;
                } else {
                    leftGreater++;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) {
                    rightLess++;
                } else {
                    rightGreater++;
                }
            }
            res += leftLess * rightGreater + leftGreater * rightLess;
        }
        return res;
    }
};