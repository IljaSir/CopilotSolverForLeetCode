class Solution {
public:
    int rand10() {
        
        int a = rand7();
        int b = rand7();
        while (a > 5) {
            a = rand7();
        }
        while (b == 7) {
            b = rand7();
        }
        return b <= 3 ? a : a + 5;
    }
};