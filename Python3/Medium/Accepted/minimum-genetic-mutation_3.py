class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        
        if endGene not in bank:
            return -1
        bank = set(bank)
        queue = [(startGene, 0)]
        while queue:
            gene, steps = queue.pop(0)
            if gene == endGene:
                return steps
            for i in range(len(gene)):
                for c in ['A', 'C', 'G', 'T']:
                    if c != gene[i]:
                        new_gene = gene[:i] + c + gene[i+1:]
                        if new_gene in bank:
                            queue.append((new_gene, steps+1))
                            bank.remove(new_gene)
        return -1