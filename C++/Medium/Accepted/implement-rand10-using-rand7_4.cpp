class Solution {
public:
    int rand10() {
        
        int num = 40;
        while (num >= 40) {
            num = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return num % 10 + 1;
    }
};