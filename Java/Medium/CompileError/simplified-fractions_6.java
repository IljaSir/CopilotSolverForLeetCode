class Solution {
    public List<String> simplifiedFractions(int n) {
        
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(j, i) == 1) {
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }
}