class Solution:
    def entityParser(self, text: str) -> str:
        
        # replace all html entities with their corresponding characters
        # use a dictionary to map the html entities to their corresponding characters
        # replace the html entities with their corresponding characters using the replace() method
        # return the string after replacing the html entities with their corresponding characters
        entities = {"&quot;": '"', "&apos;": "'", "&gt;": ">", "&lt;": "<", "&frasl;": "/", "&amp;": "&"}
        for key, value in entities.items():
            text = text.replace(key, value)
        return text