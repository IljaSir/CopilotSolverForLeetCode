class Solution extends SolBase {
    public int rand10() {
        
        int x = 0;
        int y = 0;
        int idx = 0;
        do{
            x = rand7();
            y = rand7();
            idx = y + (x - 1) * 7;
        }while(idx > 40);
        return 1 + (idx - 1) % 10;
    }
}