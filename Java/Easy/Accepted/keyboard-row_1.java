class Solution {
    public String[] findWords(String[] words) {
        
        String[] rows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                map.put(c, i);
            }
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (word.equals("")) continue;
            int index = map.get(word.toLowerCase().charAt(0));
            for (char c : word.toLowerCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) list.add(word);
        }
        return list.toArray(new String[0]);
    }
}