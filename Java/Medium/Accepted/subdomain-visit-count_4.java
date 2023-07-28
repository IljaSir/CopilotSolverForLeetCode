class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int i = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, i));
            String domain = cpdomain.substring(i + 1);
            map.put(domain, map.getOrDefault(domain, 0) + count);
            for (i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (String domain : map.keySet()) {
            res.add(map.get(domain) + " " + domain);
        }
        return res;
    }
}