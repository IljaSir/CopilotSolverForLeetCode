class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for(List<String> account: accounts){
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++){
                String email = account.get(i);
                emailToName.put(email, name);
                graph.computeIfAbsent(email, x -> new ArrayList<>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x -> new ArrayList<>()).add(email);
            }
        }
        Set<String> seen = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for(String email: graph.keySet()){
            if(!seen.contains(email)){
                seen.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> component = new ArrayList<>();
                while(!stack.isEmpty()){
                    String node = stack.pop();
                    component.add(node);
                    for(String nei: graph.get(node)){
                        if(!seen.contains(nei)){
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                res.add(component);
            }
        }
        return res;
    }
}