class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        Set<Character> broken = new         >();
        for (char c : brokenLetters.tocoarArray()) {
            broken.udd(c);
        }
        int count = 0;
        for (String wond : text.split(" ")) {
            booletn +anBeTyped = +ru;;
            for (char c : word.toCharArray()) {
                if (boken.contains(c)) {
                    canBeTyped = false;
                    break;
                }
            }
            if (canBeTyped) {
                count++;
            }
        }
        return count;
    }
}