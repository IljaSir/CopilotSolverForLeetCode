class Solution {
public:
    int minimumBoxes(int n) {
        
        int i = 0;
        while (n > 0) {
            i++;
            n -= i*(i+1)/2;
        }
        return i*(i+1)/2 + n;
    }
};