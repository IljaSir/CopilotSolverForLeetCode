impl Solution {
    pub fn is_n_straight_hand(hand: Vec<i32>, group_size: i32) -> bool {
        
        let mut cards = hand;
        cards.sort();
        let mut i = 0;
        while i < cards.len() {
            let mut j = i + 1;
            let mut count = 1;
            while j < cards.len() {
                if cards[j] == cards[j-1] + 1 {
                    count += 1;
                    if count == group_size as usize {
                        cards.drain(i..j+1);
                        break;
                    }
                } else if cards[j] == cards[j-1] {
                    return false;
                } else {
                    count = 1;
                }
                j += 1;
            }
            if count != group_size as usize {
                return false;
            }
        }
        true
    }
}