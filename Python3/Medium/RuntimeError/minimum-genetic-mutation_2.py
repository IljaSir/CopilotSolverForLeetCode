class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        
        
        if endGene not in bank:
            return -1
        
        if startGene in bank:
            bank.remove(startGene)
        
        # print(bank)
        
        def is_one_mutation(word1, word2):
            count = 0
            for i in range(len(word1)):
                if word1[i] != word2[i]:
                    count += 1
            return count == 1
        
        def find_mutation(startGene, endGene, bank, count):
            if is_one_mutation(startGene, endGene):
                return count + 1
            else:
                for i in bank:
                    if is_one_mutation(startGene, i):
                        bank.remove(i)
                        return find_mutation(i, endGene, bank, count + 1)
        
        return find_mutation(startGene, endGene, bank, 0)