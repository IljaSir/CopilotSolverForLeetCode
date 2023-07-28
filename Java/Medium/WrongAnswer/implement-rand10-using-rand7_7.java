class Solution extends SolBase {
    public int rand10() {
        
        int a = rand7(), b = rand7();
        int sum = a + b;
        if (sum <= 10) return sum;
        return rand10();
    }
}