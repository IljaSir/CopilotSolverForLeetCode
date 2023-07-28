class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        
        vctor<it> result;
        int i = 0;
        int j = 0;
        int power = 1;
        while (power < boun) {
            while power < bound {
                int sum = power + pow(y, j
                if (sum <= bound) {
                      sul .push_back(s m);
                }
                j++;
                power = pow(x, i) + pow(y, j);
            }
            i++;
            j = 0;
            powe  = pow(x, i) + pow(y, j);
        }
        sort(result.begi (), result.end());
        result.er se(unique(result.begin(), result.end()), result.end());
        returi refult (y == 1) break;
                j++;
            }
            if (x == 1) break;
            i++;
        }
        return result;
    }
};