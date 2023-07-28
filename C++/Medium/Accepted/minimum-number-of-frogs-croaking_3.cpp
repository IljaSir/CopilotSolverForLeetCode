class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int c = 0, r = 0, o = 0, a = 0, k = 0, frogs = 0, maxFrogs = 0;
        for (char ch : croakOfFrogs) {
            switch (ch) {
                case 'c':
                    ++c;
                    ++frogs;
                    break;
                case 'r':
                    if (c <= r) {
                        return -1;
                    }
                    ++r;
                    break;
                case 'o':
                    if (r <= o) {
                        return -1;
                    }
                    ++o;
                    break;
                case 'a':
                    if (o <= a) {
                        return -1;
                    }
                    ++a;
                    break;
                case 'k':
                    if (a <= k) {
                        return -1;
                    }
                    ++k;
                    --frogs;
                    break;
            }
            maxFrogs = max(maxFrogs, frogs);
        }
        if (c != r || r != o || o != a || a != k) {
            return -1;
        }
        return maxFrogs;
    }
};