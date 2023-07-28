class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        anagram = {}
        for i in strs:
            key = ''.join(sorted(i))
            if key in anagram:
                anagram[key].append(i)
            else:
                anagram[key] = [i]
        return list(anagram.values())