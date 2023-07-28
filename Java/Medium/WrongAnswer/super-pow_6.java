class Solution {
    public int superPow(int a, int[] b) {
        
        if (a == 1) return 1;
        if (a == 2) return (b[b.length - 1] & 1) == 0 ? 6 : 2;
        if (a == 3) return (b[b.length - 1] & 1) == 0 ? 1 : 3;
        if (a == 4) return (b[b.length - 1] & 1) == 0 ? 6 : 4;
        if (a == 5) return 5;
        if (a == 6) return 6;
        if (a == 7) return (b[b.length - 1] & 1) == 0 ? 1 : 7;
        if (a == 8) return (b[b.length - 1] & 1) == 0 ? 6 : 8;
        if (a == 9) return (b[b.length - 1] & 1) == 0 ? 1 : 9;
        return 0;
    }
}