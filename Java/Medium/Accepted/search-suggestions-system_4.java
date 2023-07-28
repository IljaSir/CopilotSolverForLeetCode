class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            for (String product : products) {
                if (product.length() >= i && product.substring(0, i).equals(searchWord.substring(0, i))) {
                    list.add(product);
                }
            }
            if (list.size() > 3) {
                list = list.subList(0, 3);
            }
            result.add(list);
        }
        return result;
    }
}