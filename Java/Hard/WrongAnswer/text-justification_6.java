class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;
        while (i < n) {
            int j = i + 1;
            int len = words[i].length();
            while (j < n && len + words[j].length() + j - i <= maxWidth) {
                len += words[j].length();
                j++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            int space = maxWidth - len;
            int average = j == n ? 1 : (j - i == 1 ? 0 : space / (j - i - 1));
            int extra = j == n ? 0 : (j - i == 1 ? 0 : space % (j - i - 1));
            for (int k = i + 1; k < j; k++) {
                for (int l = 0; l < average + (extra-- > 0 ? 1 : 0); l++) {
                    sb.append(' ');
                }
                sb.append(words[k]);
            }
            for (int k = sb.length(); k < maxWidth; k++) {
                sb.append(' ');
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }
}