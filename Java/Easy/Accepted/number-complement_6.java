class Solution {
    public int findComplement(int num) {
        
        int n = num;
        int i = 0;
        while (n != 0) {
            n = n >> 1;
            num = num ^ (1 << i);
            i++;
        }
        return num;
    }
}