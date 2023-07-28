class Solution {
    public String discountPrices(String sentence, int discount) {
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.charAt(0) == '$') {
                int price = Integer.parseInt(word.substring(1));
                price -= ((price * discount) / 100);
                sb.append(String.format("$%.2f", (float)price));
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}