impl Solution {
    pub fn deck_revealed_increasing(deck: Vec<i32>) -> Vec<i32> {
        
        let mut deck = deck;
        deck.sort();
        let mut res = vec![];
        while !deck.is_empty() {
            let last = deck.pop().unwrap();
            res.insert(0, last);
            if let Some(first) = res.pop() {
                res.insert(0, first);
            }
        }
        res
    }
}