class Solution {
public:
    vector<int> sumZero(int n) {
        
        vector<int> result;
        if (n == 1) {
            result.push_back(0);
            return result;
        }
        int left = 1;
        int right = n;
        while (left < right) {
            result.push_back(left);
            result.push_back(-left);
            left++;
            right--;
        }
        if (left == right) {
            result.push_back(0);
        }
        return result;
    }
};