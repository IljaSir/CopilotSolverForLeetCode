class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        if (sentence1.equals(sentence2)) {
            return true;
        }
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s1.length < s2.length) {
            String[] tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        int i = 0;
        for (; i < s2.length; i++) {
            if (!s1[i].equals(s2[i])) {
                break;
            }
        }
        if (i == s2.length) {
            return true;
        }
        for (int j = s2.length - 1; j >= 0; j--) {
            if (!s1[s1.length - s2.length + j].equals(s2[j])) {
                return false;
            }
        }
        return true;
    }
}