class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split("\\s+");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];
            map.put(domain, map.getOrDefault(domain, 0) + count);
            for (int i = 0; i < domain.length(); ++i) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
                }
            }
        }

        List<String> ans = new ArrayList();
        for (String domain : map.keySet()) {
            ans.add(map.get(domain) + " " + domain);
        }
        return ans;
    }
}