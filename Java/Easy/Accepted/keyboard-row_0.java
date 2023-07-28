class Solution {
    public String[] findWords(String[] words) {
        
        char[] row1 = {'q','w','e','r','t','y','u','i','o','p'};
        char[] row2 = {'a','s','d','f','g','h','j','k','l'};
        char[] row3 = {'z','x','c','v','b','n','m'};
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            for (int i = 0; i < word.length(); i++) {
                if (isInRow(word.charAt(i), row1)) {
                    count1++;
                } else if (isInRow(word.charAt(i), row2)) {
                    count2++;
                } else if (isInRow(word.charAt(i), row3)) {
                    count3++;
                }
            }
            if (count1 == word.length() || count2 == word.length() || count3 == word.length()) {
                list.add(word);
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean isInRow(char c, char[] row) {
        for (int i = 0; i < row.length; i++) {
            if (c == row[i] || c == Character.toUpperCase(row[i])) {
                return true;
            }
        }
        return false;
    }
}