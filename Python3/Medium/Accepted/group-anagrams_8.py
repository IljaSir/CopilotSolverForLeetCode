class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        # Anagram: rearrange the letters of a different word or phrase, typically using all the original letters exactly once.
        # so, the same letters in different order are anagrams.
        # so, we can use a dictionary to store the anagrams with the same key.
        d = {}
        for s in strs:
            key = ''.join(sorted(s))
            if key in d:
                d[key].append(s)
            else:
                d[key] = [s]
        return d.values()