impl Solution {
    pub fn deck_revealed_increasing(deck: Vec<i32>) -> Vec<i32> {
        
        let mut deck = deck;
        deck.sort();
        let mut ans = vec![];
        while !deck.is_empty() {
            let t = deck.pop().unwrap();
            ans.insert(0, t);
            if !ans.is_empty() {
                let t = ans.pop().unwrap();
                ans.insert(0, t);
            }
        }
        ans
    }
}