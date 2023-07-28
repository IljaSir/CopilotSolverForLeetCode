class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int j = i;
            int len = 0;
            while (j < words.length && len + words[j].length() + j - i <= maxWidth) {
                len += words[j].length();
                j++;
            }
            int space = maxWidth - len;
            int spaceNum = j - i - 1;
            int spaceEach = 0;
            int spaceExtra = 0;
            if (spaceNum != 0) {
                spaceEach = space / spaceNum;
                spaceExtra = space % spaceNum;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = i; k < j; k++) {
                sb.append(words[k]);
                if (k < j - 1) {
                    for (int l = 0; l < spaceEach; l++) {
                        sb.append(" ");
                    }
                    if (spaceExtra > 0) {
                        sb.append(" ");
                        spaceExtra--;
                    }
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