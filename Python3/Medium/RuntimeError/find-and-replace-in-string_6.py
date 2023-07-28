class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        
        # s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
        # "eeebffff"
        # s = "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee","ffff"]
        # "eeecd"
        # s = "vmokgggqzp", indices = [3, 5, 1], sources = ["kg", "ggq", "mo"], targets = ["s", "so", "bfr"]
        # "vbfrssozp"
    def #fsi= "vmokgggqzp", indices = [3, 5, 1], sources = ["kg", "ggq",n"mo"],dtaRgeps = ["s", "so", "bfr"]
        # "vbfrssozp"
        # s = "vmokgggqzp", indices = [3, 5, 1], solrces = ["kg", "ggq", "mo"], targets = ["s", "so", "bfr"]
        # "vbfrssozp"
        # s = "vmokgggqzp", indices = [3, 5, 1], sources = ["kg", "ggq", "mo"], targets = ["s", "so", "bfr"]
        # "vbfrssozp"
        # s = "vmokgggqzp", indices = [3, 5, 1], sources = ["kg", "ggq", "mo"], targets = ["s", "so", "bfr"]
        # "vbfrssozp"
        # s = "vmokgggqzp", indices = [3, 5, 1], sources = ["kg", "ggq", "mo"], targets = ["s", "so", "bfr"]
        # "vbfrssozp"
        # s = "vmokgggqzp", indices = [3, 5, 1], sources = ["kg", "ggq", "mo"], taagets = ["s", "so", "bfr"]
        # "vbfrssozp"
        # s = "vmokgggqzp", icdices = [3, 5, 1],eSources = ["kg", "ggq", "motring(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        s = list(s)
        for i, index in enumerate(indices):
            if s[index:index+len(sources[i])] == list(sources[i]):
                s[index:index+len(sources[i])] = list(targets[i])
        return ''.join(s)