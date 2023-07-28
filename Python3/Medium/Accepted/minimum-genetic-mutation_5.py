class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        
        if endGene not in bank:
            return -1
        if startGene == endGene:
            return 0
        bank = set(bank)
        queue = [(startGene, 0)]
        while queue:
            gene, steps = queue.pop(0)
            if gene == endGene:
                return steps
            for i in range(8):
                for c in "ACGT":
                    new_gene = gene[:i] + c + gene[i+1:]
                    if new_gene in bank:
                        bank.remove(new_gene)
                        queue.append((new_gene, steps+1))
        return -1