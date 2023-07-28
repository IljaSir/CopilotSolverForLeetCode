class Solution {
    public int[] groupStrings(String[] words) {
        
        int len = words.length;
        int[] ans = new int[2];
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int diff = word.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                char c = (char) (word.charAt(j) - diff);
                if (c < 'a') {
                    c += 26;
                }
                sb.append(c);
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(word);
            map.put(sb.toString(), list);
        }
        int max = 0;
        for (List<String> list : map.values()) {
            max = Math.max(max, list.size());
        }
        ans[0] = map.size();
        ans[1] = max;
        return ans;
    }
}