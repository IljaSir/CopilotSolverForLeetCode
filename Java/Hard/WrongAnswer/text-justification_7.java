class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int j = i;
            int sum = 0;
            while (j < words.length && sum + words[j].length() + j - i <= maxWidth) {
                sum += words[j].length();
                j++;
            }
            int spaceCount = j - i - 1;
            int spaceLength = maxWidth - sum;
            int spaceUnit = spaceCount > 0 ? spaceLength / spaceCount : 0;
            int spaceRemain = spaceCount > 0 ? spaceLength % spaceCount : 0;
            StringBuilder sb = new StringBuilder();
            for (int k = i; k < j; k++) {
                sb.append(words[k]);
                if (k < j - 1) {
                    for (int l = 0; l < spaceUnit; l++) {
                        sb.append(' ');
                    }
                    if (spaceRemain-- > 0) {
                        sb.append(' ');
                    }
                }
            }
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }
}