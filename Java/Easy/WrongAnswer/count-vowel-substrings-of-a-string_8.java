class Solution {
    public int countVowelSubstrings(String word) {
        
        int[] vowels = new int[5];
        Arrays.fill(vowels, 1);
        int ans = 0;
        for (char c : word.toCharArray()) {
            int idx = "aeiou".indexOf(c);
            if (idx > 0) vowels[idx] += vowels[idx - 1];
            ans += vowels[idx];
        }
        return ans;
    }
}