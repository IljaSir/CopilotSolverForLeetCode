class Solution {
    public String discountPrices(String sentence, int discount) {
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.startsWith("$")) {
                int price = Integer.parseInt(word.substring(1));
                int discountPrice = price - (price * discount) / 100;
                sb.append("$").append(String.format("%.2f", discountPrice / 100.0));
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}