impl Solution {
    pub fn deck_revealed_increasing(deck: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut deck = deck;
        deck.sort();
        while let Some(card) = deck.pop() {
            if let Some(last) = res.pop() {
                res.insert(0, last);
            }
            res.insert(0, card);
        }
        res
    }
}