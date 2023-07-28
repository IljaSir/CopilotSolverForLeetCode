class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        int ans = 0;
        char[] genes = {'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<String>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return ans;
                }
                char[] geneArray = gene.toCharArray();
                for (int j = 0; j < geneArray.length; j++) {
                    char old = geneArray[j];
                    for (char c : genes) {
                        geneArray[j] = c;
                        String newGene = new String(geneArray);
                        if (!visited.contains(newGene) && bankSet.contains(newGene)) {
                            queue.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    geneArray[j] = old;
                }
            }
            ans++;
        }
        return -1;
    }
}