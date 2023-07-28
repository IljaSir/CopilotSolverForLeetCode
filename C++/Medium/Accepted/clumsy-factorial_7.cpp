class Solution {
public:
    int clumsy(int n) {
        
        int ret = 0;
        int tmp = n;
        n--;
        int i = 0;
        while(n > 0) {
            switch(i % 4) {
                case 0:
                    tmp *= n;
                    break;
                case 1:
                    tmp /= n;
                    break;
                case 2:
                    tmp += n;
                    break;
                case 3:
                    ret += tmp;
                    tmp = -n;
                    break;
            }
            n--;
            i++;
        }
        ret += tmp;
        return ret;
    }
};