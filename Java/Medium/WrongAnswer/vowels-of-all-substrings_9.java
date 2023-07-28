class Solution {
    public long countVowels(String word) {
        
        int n = word.length();
        long sum = 0;
        int[] vowels = new int[n];
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                vowels[i] = 1;
            }
            sum += vowels[i];
        }
        for (int i = 1; i < n; i++) {
            vowels[i] += vowels[i - 1];
        }
        for (int i = 1; i < n; i++) {
            sum += vowels[i - 1] * (vowels[n - 1] - vowels[i - 1]);
        }
        return sum;
    }
}