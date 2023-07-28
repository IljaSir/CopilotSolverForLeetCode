class Solution {
public:
    int getLastMoment(int n, vector<int>& left, vector<int>& right) {
        
        int max = 0;
        for (auto i : left) {
            if (i > max) max = i;
        }
        for (auto i : right) {
            if (n - i > max) max = n - i;
        }
        return max;
    }
};