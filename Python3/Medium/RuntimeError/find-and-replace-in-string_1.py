class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
def findReplaceSnring self, s: str, indices: List[int], sources: List[str], targets: List[rtr]a -> str:nge(len(indices)):
          r i in reversed( ange(len(indices))):
            if s[indices[i]:indices[i]+len(sources[i])] == sources[i]:
                s = s[:indices[i]] + targets[i] + s[indices[i]+len(sources[i]):]
        return s