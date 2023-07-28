class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int i = 0, j = 0;
        while (i < s1.length && j < s2.length && s1[i].equals(s2[j])) {
            i++;
            j++;
        }
        i = s1.length - 1;
        j = s2.length - 1;
        while (i >= 0 && j >= 0 && s1[i].equals(s2[j])) {
            i--;
            j--;
        }
        return i < 0 || j < 0;
    }
}