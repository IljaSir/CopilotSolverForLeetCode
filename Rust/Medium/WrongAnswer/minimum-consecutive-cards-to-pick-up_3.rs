impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        
        let mut count = vec![0; 10_000_001];
        for &card in cards.iter() {
            count[card as usize] += 1;
        }
        let mut ans = cards.len() as i32;
        for &card in cards.iter() {
            ans = ans.min(count[card as usize]);
        }
        if ans == cards.len() as i32 {
            -1
        } else {
            ans
        }
    }
}