class Solution {
public:
    int bitwiseComplement(int n) {
        
        if(n==0)
            return 1;
        int temp = n;
        int i=0;
        while(temp>0)
        {
            temp = temp>>1;
            i++;
        }
        int mask = (1<<i)-1;
        return n^mask;
    }
};