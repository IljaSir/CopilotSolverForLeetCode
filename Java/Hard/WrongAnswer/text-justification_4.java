class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            int len = -1;
            int j = i;
            while (j < n && len + words[j].length() + 1 <= maxWidth) {
                len += words[j].length() + 1;
                j++;
            }
            int spaceNum = maxWidth - len;
            int spaceSlots = j - i - 1;
            if (j == n || spaceSlots == 0) {
                StringBuilder sb = new StringBuilder(words[i]);
                for (int k = i + 1; k < j; k++) {
                    sb.append(" ");
                    sb.append(words[k]);
                }
                for (int k = sb.length(); k < maxWidth; k++) {
                    sb.append(" ");
                }
                res.add(sb.toString());
            } else {
                int avg = spaceNum / spaceSlots;
                int r = spaceNum % spaceSlots;
                StringBuilder sb = new StringBuilder(words[i]);
                for (int k = i + 1; k < j; k++) {
                    for (int s = 0; s < avg + (k - i <= r ? 1 : 0); s++) {
                        sb.append(" ");
                    }
                    sb.append(words[k]);
                }
                res.add(sb.toString());
            }
            i = j;
        }
        return res;
    }
}