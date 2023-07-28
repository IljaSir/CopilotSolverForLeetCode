class Solution {
    public int superPow(int a, int[] b) {
        
        if (a == 0) return 0;
        if (a == 1) return 1;
        if (a == 2) return 6 - b[b.length - 1] % 4 * 2;
        if (a == 3) return 1 + b[b.length - 1] % 2 * 2;
        if (a == 4) return 6 - b[b.length - 1] % 2 * 4;
        if (a == 5) return 5;
        if (a == 6) return 6;
        if (a == 7) return 1 + b[b.length - 1] % 4 * 6;
        if (a == 8) return 6;
        if (a == 9) return 1 + b[b.length - 1] % 2 * 8;
        return 0;
    }
}