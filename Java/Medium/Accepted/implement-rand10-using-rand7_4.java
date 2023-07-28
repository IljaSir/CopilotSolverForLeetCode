class Solution extends SolBase {
    public int rand10() {
        
        int x = rand7();
        int y = rand7();
        while(x > 5) {
            x = rand7();
        }
        while(y == 7) {
            y = rand7();
        }
        return y <= 3 ? x : x + 5;
    }
}