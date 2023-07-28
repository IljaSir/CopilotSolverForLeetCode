class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        
        if endGene not in bank:
            return -1
        queue = collections.deque([(startGene, 0)])
        while queue:
            gene, step = queue.popleft()
            if gene == endGene:
                return step
            for i in range(len(gene)):
                for c in 'ACGT':
                    new_gene = gene[:i] + c + gene[i+1:]
                    if new_gene in bank:
                        bank.remove(new_gene)
                        queue.append((new_gene, step+1))
        return -1