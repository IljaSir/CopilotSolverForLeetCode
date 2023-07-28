class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int start = 0;
        while (start < words.length) {
            int end = start + 1;
            int sum = words[start].length();
            while (end < words.length && sum + 1 + words[end].length() <= maxWidth) {
                sum += 1 + words[end].length();
                end++;
            }
            int space = maxWidth - sum;
            int spaceNum = end - start - 1;
            int extraSpace = spaceNum == 0 ? 0 : space % spaceNum;
            int spacePerWord = spaceNum == 0 ? 0 : space / spaceNum;
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < end; i++) {
                sb.append(words[i]);
                if (i < end - 1) {
                    for (int j = 0; j < spacePerWord; j++) {
                        sb.append(" ");
                    }
                    if (extraSpace > 0) {
                        sb.append(" ");
                        extraSpace--;
                    }
                }
            }
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            result.add(sb.toString());
            start = end;
        }
        return result;
    }
}