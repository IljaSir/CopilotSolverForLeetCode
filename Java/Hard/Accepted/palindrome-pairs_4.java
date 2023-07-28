class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reversedRight) && map.get(reversedRight) != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(map.get(reversedRight));
                        pair.add(i);
                        result.add(pair);
                    }
                }
                if (isPalindrome(right) && right.length() != 0) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reversedLeft) && map.get(reversedLeft) != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(map.get(reversedLeft));
                        result.add(pair);
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}