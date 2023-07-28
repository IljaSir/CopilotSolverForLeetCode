class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        // Build a map of word to index
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            // check the empty string
            if (words[i].length() == 0) {
                for (int j = 0; j < words.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (isPalindrome(words[j])) {
                        res.add(Arrays.asList(i, j));
                        res.add(Arrays.asList(j, i));
                    }
                }
                continue;
            }
            // check the reversed string
            String reversed = new StringBuilder(words[i]).reverse().toString();
            if (map.containsKey(reversed) && map.get(reversed) != i) {
                res.add(Arrays.asList(i, map.get(reversed)));
            }
            // check the prefix
            for (int k = 1; k < words[i].length(); k++) {
                if (isPalindrome(words[i].substring(0, k))) {
                    String suffix = new StringBuilder(words[i].substring(k)).reverse().toString();
                    if (map.containsKey(suffix)) {
                        res.add(Arrays.asList(map.get(suffix), i));
                    }
                }
            }
            // check the suffix
            for (int k = words[i].length() - 1; k >= 0; k--) {
                if (isPalindrome(words[i].substring(k))) {
                    String prefix = new StringBuilder(words[i].substring(0, k)).reverse().toString();
                    if (map.containsKey(prefix)) {
                        res.add(Arrays.asList(i, map.get(prefix)));
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}