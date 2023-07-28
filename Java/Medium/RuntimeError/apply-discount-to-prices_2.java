class Solution {
    public String discountPrices(String sentence, int discount) {
        
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == '$') {
                String price = words[i].substring(1);
                double p = Double.parseDouble(price);
                double d = p * (discount / 100.0);
                words[i] = "$" + String.format("%.2f", p - d);
            }
        }
        return String.join(" ", words);
    }
}