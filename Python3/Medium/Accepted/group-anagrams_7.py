class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        # Solution 1: Sort each string and put them in a dict
        # Time: O(nklogk), Space: O(nk)
        # where n is the length of strs, k is the average length of each string
        # d = {}
        # for s in strs:
        #     s_sorted = ''.join(sorted(s))
        #     if s_sorted not in d:
        #         d[s_sorted] = [s]
        #     else:
        #         d[s_sorted].append(s)
        # return d.values()
        
        # Solution 2: Count the frequency of each character and put them in a dict
        # Time: O(nk), Space: O(nk)
        # where n is the length of strs, k is the average length of each string
        d = {}
        for s in strs:
            s_count = [0] * 26
            for c in s:
                s_count[ord(c) - ord('a')] += 1
            s_count = tuple(s_count)
            if s_count not in d:
                d[s_count] = [s]
            else:
                d[s_count].append(s)
        return d.values()