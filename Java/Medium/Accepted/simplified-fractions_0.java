class Solution {
    public List<String> simplifiedFractions(int n) {
        
        List<String> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    result.add(j + "/" + i);
                }
            }
        }
        return result;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}