class Solution {
    public int countPalindromes(String s) {
        
        int[] count = new int[10];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += count[i] * (count[i] - 1) / 2;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                ans += count[i] * count[j];
            }
        }
        return (int) (ans % 1000000007);
    }
}