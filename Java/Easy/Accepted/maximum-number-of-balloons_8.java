class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int count = 0;
        int[] ch = new int[26];
        for (char c : text.toCharArray()) {
            ch[c - 'a']++;
        }
        while (ch['b' - 'a'] > 0 && ch['a' - 'a'] > 0 && ch['l' - 'a'] > 1 && ch['o' - 'a'] > 1 && ch['n' - 'a'] > 0) {
            ch['b' - 'a']--;
            ch['a' - 'a']--;
            ch['l' - 'a'] -= 2;
            ch['o' - 'a'] -= 2;
            ch['n' - 'a']--;
            count++;
        }
        return count;
    }
}