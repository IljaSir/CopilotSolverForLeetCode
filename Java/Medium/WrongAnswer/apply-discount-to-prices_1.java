class Solution {
    public String discountPrices(String sentence, int discount) {
        
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == '$') {
                int price = Integer.parseInt(words[i].substring(1));
                price = (int) (price - (price * discount / 100.0));
                words[i] = "$" + String.format("%.2f", (double) price);
            }
        }
        return String.join(" ", words);
    }
}