class Solution {
public:
    int rand10() {
        
        int res = 0;
        while (res == 0) {
            res = (rand7() - 1) * 7 + rand7() - 1;
        }
        return res % 10 + 1;
    }
};