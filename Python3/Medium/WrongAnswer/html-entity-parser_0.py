class Solution:
    def entityParser(self, text: str) -> str:
        
        entities = {
            "&quot;": '"',
            "&apos;": "'",
            "&amp;": "&",
            "&gt;": ">",
            "&lt;": "<",
            "&frasl;": "/",
        }
        for k, v in entities.items():
            text = text.replace(k, v)
        return text