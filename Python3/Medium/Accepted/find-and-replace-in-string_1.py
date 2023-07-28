class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
        # 1. Sort indices in reverse order
        # 2. Iterate over indices, and for each index:
        # 3. Check if the substring sources[i] occurs at index indices[i] in the original string s.
        # 4. If it does not occur, do nothing.
        # 5. Otherwise if it does occur, replace that substring with targets[i].
        # 6. Return the resulting string after performing all replacement operations on s.
        # 7. Time complexity: O(n^2), where n is the length of s.
        # 8. Space complexity: O(n), where n is the length of s.
        # 9. Follow-up: Can we do it in O(n) time complexity?
        indices, sources, targets = zip(*sorted(zip(indices, sources, targets), reverse=True))
        for i, idx in enumerate(indices):
            if s[idx:].startswith(sources[i]):
                s = s[:idx] + targets[i] + s[idx + len(sources[i]):]
        return s