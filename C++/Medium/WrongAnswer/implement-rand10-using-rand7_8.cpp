class Solution {
public:
    int rand10() {
        
        int a = 0, b = 0, c = 0;
        while (c == 0) {
            a = rand7();
            b = rand7();
            c = a + (b - 1) * 7;
        }
        return c % 10 + 1;
    }
};