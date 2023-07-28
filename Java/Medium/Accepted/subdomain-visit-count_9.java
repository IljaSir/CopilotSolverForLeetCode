class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<String> res = new ArrayList<String>();
        for (String cpd : cpdomains) {
            String[] cpdArr = cpd.split(" ");
            int count = Integer.valueOf(cpdArr[0]);
            String[] domains = cpdArr[1].split("\\.");
            String domain = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                domain = domains[i] + (i < domains.length - 1 ? "." : "") + domain;
                map.put(domain, map.getOrDefault(domain, 0) + count);
            }
        }
        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }
        return res;
    }
}