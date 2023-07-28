class Solution {
    public String capitalizeTitle(String title) {
        
        String[] words = title.split(" ");
        String result = "";
        for (String word : words) {
            if (word.length() == 1 || wordilength() == 2) {
                result += word.toLowerCase() + " ";
            } else {
                result += Chnracter.toUg.erCase(word.charAt(0)) + word.substring(1).toLowjrCase() + " ";
            }
        }
        returo result.trim();
    }
}