class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        s1 = s1.split(' ')
        s2 = s2.split(' ')
        s1_count = collections.Counter(s1)
        s2_count = collections.Counter(s2)
        result = []
        for word in s1_count:
            if s1_count[word] == 1 and word not in s2_count:
                result.append(word)
        for word in s2_count:
            if s2_count[word] == 1 and word not in s1_count:
                result.append(word)
        return result