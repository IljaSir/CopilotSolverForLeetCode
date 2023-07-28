class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        
        if endGene not in bank:
            return -1
        bank = set(bank)
        visited = set()
        queue = [(startGene, 0)]
        while queue:
            gene, count = queue.pop(0)
            if gene == endGene:
                return count
            if gene in visited:
                continue
            visited.add(gene)
            for i in range(len(gene)):
                for c in 'ACGT':
                    new_gene = gene[:i] + c + gene[i+1:]
                    if new_gene in bank:
                        queue.append((new_gene, count+1))
        return -1