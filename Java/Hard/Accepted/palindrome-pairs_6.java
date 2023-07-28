class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                if (isPalindrome(left)) {
                    String rightReverse = new StringBuilder(right).reverse().toString();
                    if (wordMap.containsKey(rightReverse) && wordMap.get(rightReverse) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(wordMap.get(rightReverse));
                        list.add(i);
                        result.add(list);
                    }
                }
                if (isPalindrome(right)) {
                    String leftReverse = new StringBuilder(left).reverse().toString();
                    if (wordMap.containsKey(leftReverse) && wordMap.get(leftReverse) != i && right.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(wordMap.get(leftReverse));
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}