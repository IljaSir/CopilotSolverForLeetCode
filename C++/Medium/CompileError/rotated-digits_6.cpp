class Solution {
public:
    int rotatedDigits(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++)
        {
            if (isGood(i))
                count++;
        }
        return count;
    }
};