class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        List<String> ans = new LinkedList<String>();
        Arrays.sort(folder);
        for (String f : folder) {
            if (ans.isEmpty() || !f.startsWith(ans.get(ans.size() - 1) + "/")) {
                ans.add(f);
            }
        }
        return ans;
    }
}