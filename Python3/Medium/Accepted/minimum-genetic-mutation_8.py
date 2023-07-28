class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        
        # BFS
        if not startGene or not endGene or not bank:
            return -1
        if endGene not in bank:
            return -1
        bank = set(bank)
        queue = collections.deque()
        queue.append((startGene, 0))
        while queue:
            cur, step = queue.popleft()
            if cur == endGene:
                return step
            for i in range(len(cur)):
                for j in "ACGT":
                    new = cur[:i] + j + cur[i+1:]
                    if new in bank:
                        bank.remove(new)
                        queue.append((new, step+1))
        return -1