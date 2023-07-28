class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (map.containsKey(sorted)) {
                int index = map.get(sorted);
                if (words[index].length() > word.length()) {
                    map.put(sorted, i);
                    result.set(index, word);
                }
            } else {
                map.put(sorted, i);
                result.add(word);
            }
        }
        return result;
    }
}