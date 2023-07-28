impl Solution {
    pub fn deck_revealed_increasing(deck: Vec<i32>) -> Vec<i32> {
        
        let mut deck = deck;
        deck.sort();
        let mut result = Vec::new();
        result.push(deck.pop().unwrap());
        while !deck.is_empty() {
            let last = result.pop().unwrap();
            result.insert(0, last);
            result.insert(0, deck.pop().unwrap());
        }
        result
    }
}