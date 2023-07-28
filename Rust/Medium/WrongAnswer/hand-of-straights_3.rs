impl Solution {
    pub fn is_n_straight_hand(hand: Vec<i32>, group_size: i32) -> bool {
        
        if hand.len() % group_size as usize != 0 {
            return false;
        }
        let mut hand = hand;
        hand.sort();
        let mut i = 0;
        while i < hand.len() {
            let mut j = i + 1;
            let mut count = 1;
            while j < hand.len() && count < group_size as usize {
                if hand[j] == hand[j - 1] + 1 {
                    count += 1;
                } else if hand[j] != hand[j - 1] {
                    return false;
                }
                j += 1;
            }
            if count != group_size as usize {
                return false;
            }
            hand.drain(i..j);
        }
        true
    }
}