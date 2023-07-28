impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        
        let mut cards = cards;
        cards.sort();
        let mut min = std::i32::MAX;
        let mut count = 1;
        for i in 1..cards.len() {
            if cards[i] == cards[i - 1] {
                count += 1;
            } else {
                if count > 1 {
                    min = min.min(i as i32);
                }
                count = 1;
            }
        }
        if count > 1 {
            min = min.min(cards.len() as i32);
        }
        if min == std::i32::MAX {
            -1
        } else {
            min
        }
    }
}