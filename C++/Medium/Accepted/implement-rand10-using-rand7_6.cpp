class Solution {
public:
    int rand10() {
        
        int result = 0;
        do {
            result = (rand7() - 1) * 7 + rand7();
        } while (result > 40);
        return result % 10 + 1;
    }
};