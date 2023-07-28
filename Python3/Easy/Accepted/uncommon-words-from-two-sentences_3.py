class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        s1 = s1.split()
        s2 = s2.split()
        s1_dict = {}
        s2_dict = {}
        for word in s1:
            if word not in s1_dict:
                s1_dict[word] = 1
            else:
                s1_dict[word] += 1
        for word in s2:
            if word not in s2_dict:
                s2_dict[word] = 1
            else:
                s2_dict[word] += 1
        result = []
        for word in s1_dict:
            if s1_dict[word] == 1 and word not in s2_dict:
                result.append(word)
        for word in s2_dict:
            if s2_dict[word] == 1 and word not in s1_dict:
                result.append(word)
        return result