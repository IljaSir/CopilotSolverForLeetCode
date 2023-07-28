class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        
        char[] geneOptions = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return level;
                }
                
                char[] geneChars = gene.toCharArray();
                for (int j = 0; j < geneChars.length; j++) {
                    char originalChar = geneChars[j];
                    for (char c : geneOptions) {
                        if (c == originalChar) {
                            continue;
                        }
                        
                        geneChars[j] = c;
                        String newGene = new String(geneChars);
                        if (bankSet.contains(newGene)) {
                            queue.offer(newGene);
                            bankSet.remove(newGene);
                        }
                    }
                    geneChars[j] = originalChar;
                }
            }
            level++;
        }
        
        return -1;
    }
}