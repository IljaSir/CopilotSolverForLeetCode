class Solution {
    public String discountPrices(String sentence, int discount) {
        
        String[] words = sentence.split(" ");
        String[] newWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.startsWith("$")) {
                String price = word.substring(1);
                try {
                    double discountPrice = Double.parseDouble(price) * (1.0 - (discount / 100.0));
                    newWords[i] = "$" + String.format("%.2f", discountPrice);
                } catch (NumberFormatException e) {
                    newWords[i] = "$0.00";
                }
            } else {
                newWords[i] = word;
            }
        }
        return String.join(" ", newWords);
    }
}