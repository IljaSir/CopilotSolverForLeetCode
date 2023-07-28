class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        if (startGene.equals(endGene)) {
            return 0;
        }
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        return bfs(startGene, endGene, bankSet);
    }

    private int bfs(String startGene, String endGene, Set<String> bankSet) {
        int step = 0;
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return step;
                }
                char[] geneArray = gene.toCharArray();
                for (int j = 0; j < geneArray.length; j++) {
                    char originChar = geneArray[j];
                    for (char c : charSet) {
                        if (c == originChar) {
                            continue;
                        }
                        geneArray[j] = c;
                        String newGene = new String(geneArray);
                        if (bankSet.contains(newGene)) {
                            queue.offer(newGene);
                            bankSet.remove(newGene);
                        }
                    }
                    geneArray[j] = originChar;
                }
            }
            step++;
        }
        return -1;
    }
}