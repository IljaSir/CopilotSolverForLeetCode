class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Map<String, TreeSet<String>> union = new HashMap<>();
        
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                parent.put(account.get(i), account.get(i));
                owner.put(account.get(i), account.get(0));
            }
        }
        
        for (List<String> account : accounts) {
            String p = find(account.get(1), parent);
            for (int i = 2; i < account.size(); i++) {
                parent.put(find(account.get(i), parent), p);
            }
        }
        
        for (List<String> account : accounts) {
            String p = find(account.get(1), parent);
            if (!union.containsKey(p)) {
                union.put(p, new TreeSet<>());
            }
            for (int i = 1; i < account.size(); i++) {
                union.get(p).add(account.get(i));
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (String p : union.keySet()) {
            List<String> emails = new ArrayList<>(union.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        
        return res;
    }
}