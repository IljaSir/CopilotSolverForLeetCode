impl Solution {
    pub fn deck_revealed_increasing(deck: Vec<i32>) -> Vec<i32> {
        
        let mut deck = deck;
        deck.sort();
        let mut result = Vec::new();
        while deck.len() > 0 {
            let last = deck.pop().unwrap();
            if result.len() > 0 {
                let first = result.remove(0);
                result.push(first);
            }
            result.push(last);
        }
        result.reverse();
        result
    }
}