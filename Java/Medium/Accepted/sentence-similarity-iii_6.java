class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int l1 = s1.length;
        int l2 = s2.length;
        if (l1 > l2) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        for (int i = 0; i < l1; i++) {
            if (!s1[i].equals(s2[i])) {
                for (int j = 0; j < l1 - i; j++) {
                    if (!s1[l1 - j - 1].equals(s2[l2 - j - 1])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }
}