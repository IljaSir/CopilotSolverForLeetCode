class Solution {
    public String discountPrices(String sentence, int discount) {
        
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == '$') {
                double price = Double.parseDouble(words[i].substring(1));
                double discountPrice = price - (price * discount / 100.0);
                words[i] = "$" + String.format("%.2f", discountPrice);
            }
        }
        return String.join(" ", words);
    }
}