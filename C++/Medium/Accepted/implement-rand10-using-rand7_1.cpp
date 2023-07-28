class Solution {
public:
    int rand10() {
        
        while (true) {
            int row = rand7();
            int col = rand7();
            int idx = col + (row - 1) * 7;
            if (idx <= 40) {
                return 1 + (idx - 1) % 10;
            }
            row = idx - 40;
            col = rand7();
            idx = col + (row - 1) * 7;
            if (idx <= 60) {
                return 1 + (idx - 1) % 10;
            }
            row = idx - 60;
            col = rand7();
            idx = col + (row - 1) * 7;
            if (idx <= 20) {
                return 1 + (idx - 1) % 10;
            }
        }
    }
};