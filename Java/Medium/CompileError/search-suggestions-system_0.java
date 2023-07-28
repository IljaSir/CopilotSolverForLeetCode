class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        TrieNode root = new TrieNode();
        for (String product: products) {
            TrieNode node = root;
            for (char c: product.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                node.products.add(product);
            }
        }
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for (char c: searchWord.toCharArray()) {
            if (node == null) {
                result.add(new ArrayList<>());
            } else {
                node = node.children[c - 'a'];
                if (node == null) {
                    result.add(new ArrayList<>());
                } else {
                    Collections.sort(node.products);
                    result.add(node.products.subList(0, Math.min(3, node.products.size())));
                }
            }
        }
        return result;
    }
}
    }
}