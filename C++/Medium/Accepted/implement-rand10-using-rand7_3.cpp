class Solution {
public:
    int rand10() {
        
        int rand40 = 40;
        while (rand40 >= 40) {
            rand40 = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return rand40 % 10 + 1;
    }
};