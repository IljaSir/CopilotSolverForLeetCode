class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        
        if endGene not in bank:
            return -1
        bank = set(bank)
        queue = collections.deque([(startGene, 0)])
        while queue:
            gene, steps = queue.popleft()
            if gene == endGene:
                return steps
            for i in range(len(gene)):
                for c in 'ACGT':
                    new_gene = gene[:i] + c + gene[i+1:]
                    if new_gene in bank:
                        bank.remove(new_gene)
                        queue.append((new_gene, steps + 1))
        return -1