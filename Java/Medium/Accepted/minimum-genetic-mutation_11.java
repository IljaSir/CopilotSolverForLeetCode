class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        int[] visited = new int[bank.length];
        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return steps;
                }
                for (int j = 0; j < bank.length; j++) {
                    if (visited[j] == 0 && isValid(gene, bank[j])) {
                        queue.offer(bank[j]);
                        visited[j] = 1;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private boolean isValid(String gene, String bank) {
        int diff = 0;
        for (int i = 0; i < gene.length(); i++) {
            if (gene.charAt(i) != bank.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}