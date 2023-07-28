class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            String sub = searchWord.substring(0, i + 1);
            List<String> list = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(sub)) {
                    list.add(product);
                }
                if (list.size() == 3) {
                    break;
                }
            }
            res.add(list);
        }
        return res;
    }
}