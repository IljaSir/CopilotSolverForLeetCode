class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int res = 0;
        Map<Character, List<String>> map = new HashMap<>();
        for (String word : words) {
            map.putIfAbsent(word.charAt(0), new ArrayList<>());
            map.get(word.charAt(0)).add(word);
        }
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                List<String> list = map.remove(c);
                for (String word : list) {
                    if (word.length() == 1) {
                        res++;
                    } else {
                        map.putIfAbsent(word.charAt(1), new ArrayList<>());
                        map.get(word.charAt(1)).add(word.substring(1));
                    }
                }
            }
        }
        return res;
    }
}