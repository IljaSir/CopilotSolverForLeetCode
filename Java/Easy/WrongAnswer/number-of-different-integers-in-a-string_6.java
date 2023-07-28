class Solution {
    public int numDifferentIntegers(String word) {
        
        Set<String> set = new HashSet<>();
        StringBuilder num = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            if(Character.isDigit(word.charAt(i))) {
                num.append(word.charAt(i));
            } else {
                if(num.length() > 0) {
                    set.add(num.toString());
                    num = new StringBuilder();
                }
            }
        }
        if(num.length() > 0) {
            set.add(num.toString());
        }
        return set.size();
    }
}