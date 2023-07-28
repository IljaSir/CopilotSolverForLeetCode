class Solution:
    def discountPrices(self, sentence: str, discount: int) -> str:
        
        # print(sentence)
        # print(discount)
        # print(sentence.split())
        # print(sentence.split().split("$"))
        # print(sentence.split().split("$")[1])
        # print([sentence.split().split("$")[1] for sentence.split() in sentence.split()])
        # print([sentence.split().split("$")[1] for sentence.split() in sentence.split() if sentence.split().split("$")[1]])
        # print([sentence.split().split("$")[1] for sentence.split() in sentence.split() if sentence.split().split("$")[1] and sentence.split().split("$")[1].isdigit()])
        # print([sentence.split().split("$")[1] for sentence.split() in sentence.split() if sentence.split().split("$")[1] and sentence.split().split("$")[1].isdigit() and int(sentence.split().split("$")[1]) > 0])
        # print([sentence.split().split("$")[1] for sentence.split() in sentence.split() if sentence.split().split("$")[1] and sentence.split().split("$")[1].isdigit() and int(sentence.split().split("$")[1]) > 0 and int(sentence.split().split("$")[1]) < 10**10])
        # print([sentence.split().split("$")[1] for sentence.split() in sentence.split() if sentence.split().split("$")[1] and sentence.split().split("$")[1].isdigit() and int(sentence.split().split("$")[1]) > 0 and int(sentence.split().split("$")[1]) < 10**10 and len(sentence.split().split("$")[1]) <= 10])
        # print([sentence.split().split("$")[1] for sentence.split() in sentence.split() if sentence.split().split("$")[1] and sentence.split().split("$")[1].isdigit() and int(sentence.split().split("$")[1]) > 0 and int(sentence.split().split("$")[1]) < 10**10 and len(sentence.split().split("$")[1]) <= 10 and len(sentence.split().split("$")[1]) > 0])
        # print([sentence.split().split("$")[1] for sentence.split() in sentence.split() if sentence.split().split("$")[1] and sentence.split().split("$")[1].isdigit() and int(sentence.split().split("$")[1]) > 0 and int(sentence.split().split("$")[1]) < 10**10 and len(sentence.split().