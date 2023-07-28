class Solution {
    public int monkeyMove(int n) {
        
        int mod = 1000000007;
        return (int) ((long) (n - 2) * (long) (n - 2) % mod);
    }
}