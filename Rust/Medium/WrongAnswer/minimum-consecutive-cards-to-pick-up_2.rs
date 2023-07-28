impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        
        let mut cards = cards;
        cards.sort();
        let mut min = 0;
        let mut count = 1;
        for i in 1..cards.len() {
            if cards[i] == cards[i-1] {
                count += 1;
            } else {
                if count == 1 {
                    min = 0;
                } else if min == 0 {
                    min = count;
                } else {
                    min = min.min(count);
                }
                count = 1;
            }
        }
        if count == 1 {
            min = 0;
        } else if min == 0 {
            min = count;
        } else {
            min = min.min(count);
        }
        if min == 0 {
            -1
        } else {
            min as i32
        }
    }
}