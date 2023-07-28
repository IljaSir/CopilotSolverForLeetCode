class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        s1 = s1.split(' ')
        s2 = s2.split(' ')
        s1_dict = {}
        s2_dict = {}
        for word in s1:
            if word in s1_dict:
                s1_dict[word] += 1
            else:
                s1_dict[word] = 1
        for word in s2:
            if word in s2_dict:
                s2_dict[word] += 1
            else:
                s2_dict[word] = 1
        uncommon_words = []
        for word in s1_dict:
            if s1_dict[word] == 1 and word not in s2_dict:
                uncommon_words.append(word)
        for word in s2_dict:
            if s2_dict[word] == 1 and word not in s1_dict:
                uncommon_words.append(word)
        return uncommon_words