class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            String prefix = searchWord.substring(0, i);
            for (String product : products) {
                if (product.startsWith(prefix)) {
                    list.add(product);
                    if (list.size() == 3) break;
                }
            }
            result.add(list);
        }
        return result;
    }
}