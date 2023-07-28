class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); i++) {
            String sub = searchWord.substring(0, i);
            List<String> list = new ArrayList<>();
            for (String product : products) {
                if (product.length() < i) {
                    continue;
                }
                if (product.substring(0, i).equals(sub)) {
                    list.add(product);
                }
                if (list.size() == 3) {
                    break;
                }
            }
            result.add(list);
        }
        return result;
    }
}