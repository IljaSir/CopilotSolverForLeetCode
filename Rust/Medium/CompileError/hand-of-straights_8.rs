impl Solution {
    pub fn is_n_straight_hand(hand: Vec<i32>, group_size: i32) -> bool {
        
        let mut hand = hand;
        hand.sort();
        let mut v = vec![0; hand.len()];
        for i in 0..hand.len() {
            if v[i] == 1 {
                continue;
            }
            let mut j = i + 1;
            let mut count = 1;
            while j < hand.len() {
                if hand[j] == hand[i] + count && v[j] == 0 {
                    count += 1;
                    v[j] = 1;
                    if count == group_size as usize {
                        break;
                    }
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