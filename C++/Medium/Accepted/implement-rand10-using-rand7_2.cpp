class Solution {
public:
    int rand10() {
        
        int res = 40;
        while (res >= 40) {
            res = (rand7() - 1) * 7 + rand7() - 1;
        }
        return res % 10 + 1;
    }
};