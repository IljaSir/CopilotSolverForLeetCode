class Solution {
public:
    int rotatedDigits(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int d = i;
            int good = 0;
            int bad = 0;
            while (d > 0) {
                int r = d % 10;
                d /= 10;
                switch (r) {
                    case 0:
                    case 1:
                    case 8:
                        break;
                    case 2:
                    case 5:
                    case 6:
                    case 9:
                        good = 1;
                        break;
                    default:
                        bad = 1;
                        break;
                }
            }
            if (good && !bad) {
                count++;
            }
        }
        return count;
    }
};