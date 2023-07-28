class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String s1 = word.substring(0, j);
                String s2 = word.substring(j);
                if (isPalindrome(s1)) {
                    String s2rvs = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2rvs) && map.get(s2rvs) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(s2rvs));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (isPalindrome(s2)) {
                    String s1rvs = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1rvs) && map.get(s1rvs) != i && s2.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(s1rvs));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}