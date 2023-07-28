class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int j = i;
            int len = 0;
            while (j < words.length && len + words[j].length() <= maxWidth) {
                len += words[j].length() + 1;
                j++;
            }
            int space = maxWidth - len + 1;
            int spaceLen = 1;
            int extraSpace = 0;
            if (j - i != 1 && j != words.length) {
                spaceLen = space / (j - i - 1);
                extraSpace = space % (j - i - 1);
            }
            StringBuilder sb = new StringBuilder();
            for (int k = i; k < j; k++) {
                sb.append(words[k]);
                if (k != j - 1) {
                    for (int l = 0; l < spaceLen; l++) {
                        sb.append(" ");
                    }
                }
                if (extraSpace != 0) {
                    sb.append(" ");
                    extraSpace--;
                }
            }
            for (int k = sb.length(); k < maxWidth; k++) {
                sb.append(" ");
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}