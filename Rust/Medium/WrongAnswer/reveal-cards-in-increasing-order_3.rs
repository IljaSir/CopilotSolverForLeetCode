impl Solution {
    pub fn deck_revealed_increasing(deck: Vec<i32>) -> Vec<i32> {
        
        let mut deck = deck;
        deck.sort();
        let mut res: Vec<i32> = Vec::new();
        let mut i = 0;
        while i < deck.len() {
            if i == 0 {
                res.push(deck[i]);
            } else {
                let temp = res.pop().unwrap();
                res.insert(0, temp);
                res.insert(0, deck[i]);
            }
            i += 1;
        }
        res
    }
}