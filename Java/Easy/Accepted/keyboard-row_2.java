class Solution {
    public String[] findWords(String[] words) {
        
        String[] keyboard = new String[]{"qwertyuiopQWERTYUIOP","asdfghjklASDFGHJKL","zxcvbnmZXCVBNM"};
        List<String> result = new ArrayList<>();
        for (String word: words) {
            for (String row: keyboard) {
                if (row.indexOf(word.charAt(0)) >= 0) {
                    if (word.chars().allMatch(c -> row.indexOf(c) >= 0)) {
                        result.add(word);
                    }
                    break;
                }
            }
        }
        return result.toArray(new String[0]);
    }
}