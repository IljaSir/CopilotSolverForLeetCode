class Solution extends SolBase {
    public int rand10() {
        
        int x = 0;
        do {
            x = rand7() + (rand7() - 1) * 7;
        } while (x > 40);
        return x % 10 + 1;
    }
}