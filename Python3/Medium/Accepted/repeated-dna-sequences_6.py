class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        seqs = set()
        repeated = set()
        for i in range(len(s)-9):
            seq = s[i:i+10]
            if seq in seqs:
                repeated.add(seq)
            else:
                seqs.add(seq)
        return list(repeated)