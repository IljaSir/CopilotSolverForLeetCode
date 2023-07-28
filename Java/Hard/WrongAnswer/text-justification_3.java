class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            int len = words[i].length();
            while (j < n && len + words[j].length() + (j - i - 1) < maxWidth) {
                len += words[j].length();
                j++;
            }
            int space = j - i - 1;
            StringBuilder sb = new StringBuilder(words[i]);
            if (j == n || space == 0) {
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ");
                    sb.append(words[k]);
                }
                for (int k = sb.length(); k < maxWidth; k++) {
                    sb.append(" ");
                }
            } else {
                int avg = (maxWidth - len) / space;
                int extra = (maxWidth - len) % space;
                for (int k = i + 1; k < j; k++) {
                    for (int l = 0; l < avg; l++) {
                        sb.append(" ");
                    }
                    if (extra > 0) {
                        sb.append(" ");
                        extra--;
                    }
                    sb.append(" ");
                    sb.append(words[k]);
                }
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }
}