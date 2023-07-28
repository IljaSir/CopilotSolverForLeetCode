class Solution {
    public int findTheWinner(int n, int k) {
        
        var result = 0;
        for (var i = 1; i <= n; i++) {
            result = (result + k) % i;
        }
        return result + 1;
    }
}