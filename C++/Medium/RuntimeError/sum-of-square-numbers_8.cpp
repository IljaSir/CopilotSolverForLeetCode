class Solution {
public:
    bool judgeSquareSum(int c) {
        
        if (c < 0) return false;
        if (c == 0) return true;
        int i = 0, j = sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) return true;
            else if (sum < c) i++;
            else j--;
        }
        return false;
    }
};