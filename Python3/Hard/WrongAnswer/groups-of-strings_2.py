class Solution:
    def groupStrings(self, words: List[str]) -> List[int]:
        
        def is_connected(s1, s2):
            if len(s1) != len(s2):
                return False
            if s1 == s2:
                return True
            for i in range(len(s1)):
                if s1[i] == s2[i]:
                    continue
                if s1[i] > s2[i]:
                    return False
                if ord(s2[i]) - ord(s1[i]) != 1:
                    return False
            return True
        
        def dfs(idx, group):
            nonlocal max_group_size
            for i in range(idx + 1, len(words)):
                if is_connected(words[idx], words[i]):
                    group.add(i)
                    dfs(i, group)
                    group.remove(i)
            max_group_size = max(max_group_size, len(group))
        
        max_group_size = 0
        group = set()
        for i in range(len(words)):
            group.add(i)
            dfs(i, group)
            group.remove(i)
        return [len(group), max_group_size]