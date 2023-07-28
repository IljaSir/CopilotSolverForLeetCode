impl Solution {
    pub fn is_n_straight_hand(hand: Vec<i32>, group_size: i32) -> bool {
        
        let mut hand = hand;
        hand.sort();
        let mut i = 0;
        while i < hand.len() {
            let mut j = i + 1;
            let mut count = 1;
            while j < hand.len() {
                if hand[j] != hand[i] {
                    if count == group_size {
                        break;
                    }
                    if hand[j] != hand[i] + 1 {
                        return false;
                    }
                    count = 1;
                } else {
                    count += 1;
                }
                j += 1;
            }
            if count != group_size {
                return false;
            }
            i = j;
        }
        true
    }
}