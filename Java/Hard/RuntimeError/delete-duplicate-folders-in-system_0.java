class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        TrieNode root = new TrieNode();
        for (List<String> path : paths) {
            TrieNode node = root;
            for (String folder : path) {
                if (!node.children.containsKey(folder)) {
                    node.children.put(folder, new TrieNode());
                }
                node = node.children.get(folder);
            }
        }
        Map<String, Integer> count = new HashMap<>();
        Map<String, TrieNode> nodes = new HashMap<>();
        dfs(root, count, nodes);
        List<List<String>> res = new ArrayList<>();
        for (List<String> path : paths) {
            TrieNode node = root;
            List<String> tmp = new ArrayList<>();
            for (String folder : path) {
                tmp.add(folder);
                node = node.children.get(folder);
                if (nodes.get(node.path).count > 1) {
                    break;
                }
            }
            if (node.count == 1) {
                res.add(tmp);
            }
        }
        return res;
    }

    private void dfs(TrieNode node, Map<String, Integer> count, Map<String, TrieNode> nodes) {
        if (node.children.isEmpty()) {
            node.count = 1;
            return;
        }
        for (TrieNode child : node.children.values()) {
            child.path = node.path + "/" + child.val;
            dfs(child, count, nodes);
            node.count += child.count;
        }
        count.put(node.path, node.count);
        nodes.put(node.path, node);
    }

    class TrieNode {
        String val;
        String path;
        int count;
        Map<String, TrieNode> children;

        public TrieNode() {
            this.val = "";
            this.path = "";
            this.count = 0;
            this.children = new HashMap<>();
        }

        public TrieNode(String val) {
            this.val = val;
            this.path = val;
            this.count = 0;
            this.children = new HashMap<>();
        }
    }
}