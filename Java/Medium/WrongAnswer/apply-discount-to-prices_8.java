class Solution {
    public String discountPrices(String sentence, int discount) {
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.startsWith("$")) {
                int price = Integer.parseInt(word.substring(1));
                int discountedPrice = price - price * discount / 100;
                sb.append("$").append(String.format("%.2f", discountedPrice / 100.0));
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}