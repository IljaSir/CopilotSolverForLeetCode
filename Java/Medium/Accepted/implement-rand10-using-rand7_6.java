class Solution extends SolBase {
    public int rand10() {
        
        int r = 40;
        while (r >= 40) {
            r = (rand7()-1) * 7 + (rand7()-1);
        }
        return r%10 + 1;
    }
}