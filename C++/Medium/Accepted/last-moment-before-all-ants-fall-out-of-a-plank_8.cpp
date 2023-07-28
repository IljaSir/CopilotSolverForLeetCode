class Solution {
public:
    int getLastMoment(int n, vector<int>& left, vector<int>& right) {
        
        int maxLeft = 0, maxRight = 0;
        for(int i=0;i<left.size();i++)
            maxLeft = max(maxLeft, left[i]);
        for(int i=0;i<right.size();i++)
            maxRight = max(maxRight, n-right[i]);
        return max(maxLeft, maxRight);
    }
};