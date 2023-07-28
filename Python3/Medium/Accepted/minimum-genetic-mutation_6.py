class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        
        bank = set(bank)
        if endGene not in bank:
            return -1
        startGene, endGene = set([startGene]), set([endGene])
        step = 0
        while startGene:
            step += 1
            nextStartGene = set()
            for gene in startGene:
                for i in range(8):
                    for c in 'ACGT':
                        nextGene = gene[:i] + c + gene[i+1:]
                        if nextGene in endGene:
                            return step
                        if nextGene in bank:
                            bank.remove(nextGene)
                            nextStartGene.add(nextGene)
            startGene = nextStartGene
            if len(startGene) > len(endGene):
                startGene, endGene = endGene, startGene
        return -1