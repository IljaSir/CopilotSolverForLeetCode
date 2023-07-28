impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        
        let mut cards = cards;
        cards.sort();
        let mut min = cards.len() as i32;
        let mut count = 1;
        for i in 1..cards.len() {
            if cards[i] == cards[i-1] {
                count += 1;
            } else {
                min = min.min(count);
                count = 1;
            }
        }
        min.min(count)
    }
}