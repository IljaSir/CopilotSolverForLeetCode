class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visited.add(startGene);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return steps;
                }
                for (String nextGene : getNextGenes(gene, bankSet)) {
                    if (!visited.contains(nextGene)) {
                        queue.add(nextGene);
                        visited.add(nextGene);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private List<String> getNextGenes(String gene, Set<String> bankSet) {
        List<String> nextGenes = new ArrayList<>();
        char[] geneChars = gene.toCharArray();
        for (int i = 0; i < geneChars.length; i++) {
            char oldChar = geneChars[i];
            for (char newChar : new char[]{'A', 'C', 'G', 'T'}) {
                if (newChar != oldChar) {
                    geneChars[i] = newChar;
                    String nextGene = new String(geneChars);
                    if (bankSet.contains(nextGene)) {
                        nextGenes.add(nextGene);
                    }
                }
            }
            geneChars[i] = oldChar;
        }
        return nextGenes;
    }
}