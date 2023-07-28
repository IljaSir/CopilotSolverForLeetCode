class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        int size = products.length;
        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            String sub = searchWord.substring(0, i);
            for (int j = 0; j < size; j++) {
                if (products[j].startsWith(sub)) {
                    list.add(products[j]);
                    if (list.size() == 3) {
                        break;
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}