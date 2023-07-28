class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<String>();
        List<String> line = new ArrayList<String>();
        int len = 0;
        for (String word : words) {
            if (len + line.size() + word.length() > maxWidth) {
                result.add(justify(line, len, maxWidth, false));
                line.clear();
                len = 0;
            }
            line.add(word);
            len += word.length();
        }
        result.add(justify(line, len, maxWidth, true));
        return result;
    }

    private String justify(List<String> line, int len, int maxWidth, boolean isLast) {
        StringBuilder sb = new StringBuilder();
        int spaces = maxWidth - len;
        int gaps = line.size() - 1;
        if (gaps == 0 || isLast) {
            for (String word : line) {
                sb.append(word);
                if (spaces > 0) {
                    sb.append(' ');
                    spaces--;
                }
            }
            while (spaces > 0) {
                sb.append(' ');
                spaces--;
            }
        } else {
            int spacesPerGap = spaces / gaps;
            int extraSpaces = spaces % gaps;
            for (int i = 0; i < line.size(); i++) {
                sb.append(line.get(i));
                if (i < gaps) {
                    for (int j = 0; j < spacesPerGap; j++) {
                        sb.append(' ');
                    }
                    if (extraSpaces > 0) {
                        sb.append(' ');
                        extraSpaces--;
                    }
                }
            }
        }
        return sb.toString();
    }
}