class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], orderMap) > 0) {
                return false;
            }
        }
        return true;
    }
    
    private int compare(String a, String b, int[] order) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            int cmp = order[a.charAt(i) - 'a'] - order[b.charAt(j) - 'a'];
            if (cmp != 0) {
                return cmp;
            }
            i++;
            j++;
        }
        return a.length() - b.length();
    }
}