class Solution {
    public String discountPrices(String sentence, int discount) {
        
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.charAt(0) == '$') {
                String price = word.substring(1);
                if (price.matches("[0-9]+")) {
                    int value = Integer.parseInt(price);
                    value = value - value * discount / 100;
                    words[i] = "$" + String.format("%.2f", value / 100.0);
                }
            }
        }
        return String.join(" ", words);
    }
}