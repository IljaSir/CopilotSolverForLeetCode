class Solution {
public:
    int getLastMoment(int n, vector<int>& left, vector<int>& right) {
        
        int max_left = 0;
        int max_right = 0;
        int i = 0;
        for (i = 0; i < left.size(); i++) {
            max_left = max(max_left, left[i]);
        }
        for (i = 0; i < right.size(); i++) {
            max_right = max(max_right, n - right[i]);
        }
        return max(max_left, max_right);
    }
};