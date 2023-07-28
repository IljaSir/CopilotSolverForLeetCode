class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String a, String b, int[] orderMap) {
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (orderMap[a.charAt(i) - 'a'] < orderMap[b.charAt(i) - 'a']) {
                return true;
            } else if (orderMap[a.charAt(i) - 'a'] > orderMap[b.charAt(i) - 'a']) {
                return false;
            }
            i++;
        }
        return a.length() <= b.length();
    }
}