class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> lines = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int j = i + 1, len = words[i].length();
            while (j < words.length && len + words[j].length() + j - i <= maxWidth) {
                len += words[j].length();
                j++;
            }
            StringBuilder sb = new StringBuilder(words[i]);
            int space = 1, extra = 0;
            if (j != i + 1 && j != words.length) {
                space = (maxWidth - len) / (j - i - 1) + 1;
                extra = (maxWidth - len) % (j - i - 1);
            }
            for (int k = i + 1; k < j; k++) {
                for (int s = space; s > 0; s--) {
                    sb.append(' ');
                }
                if (extra > 0) {
                    sb.append(' ');
                    extra--;
                }
                sb.append(words[k]);
            }
            int strLen = sb.length();
            for (int k = strLen; k < maxWidth; k++) {
                sb.append(' ');
            }
            lines.add(sb.toString());
            i = j;
        }
        return lines;
    }
}