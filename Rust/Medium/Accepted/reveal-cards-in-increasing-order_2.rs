impl Solution {
    pub fn deck_revealed_increasing(deck: Vec<i32>) -> Vec<i32> {
        
        let mut deck = deck;
        deck.sort();
        let mut res = Vec::new();
        while let Some(num) = deck.pop() {
            if let Some(last) = res.pop() {
                res.insert(0, last);
            }
            res.insert(0, num);
        }
        res
    }
}