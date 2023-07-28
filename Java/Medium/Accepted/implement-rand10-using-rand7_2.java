class Solution extends SolBase {
    public int rand10() {
        
        int x = rand7();
        int y = rand7();
        int idx = x + (y - 1) * 7;
        while (idx > 40) {
            x = rand7();
            y = rand7();
            idx = x + (y - 1) * 7;
        }
        return 1 + (idx - 1) % 10;
    }
}