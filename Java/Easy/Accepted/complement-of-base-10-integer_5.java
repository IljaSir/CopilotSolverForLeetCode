class Solution {
    public int bitwiseComplement(int n) {
        
        if (n == 0) return 1;
        int result = 0;
        int power = 1;
        while (n > 0) {
            result += (n % 2 == 0 ? 1 : 0) * power;
            power *= 2;
            n /= 2;
        }
        return result;
    }
}