impl Solution {
    pub fn is_n_straight_hand(hand: Vec<i32>, group_size: i32) -> bool {
        
        let n = hand.len();
        if n % group_size as usize != 0 {
            return false;
        }
        let mut hand = hand;
        hand.sort();
        let mut i = 0;
        while i < n {
            let mut j = i;
            while j + 1 < n && hand[j + 1] == hand[j] {
                j += 1;
            }
            if j - i + 1 > group_size as usize {
                return false;
            }
            let mut k = i;
            while k <= j {
                hand[k] += group_size;
                k += 1;
            }
            i = j + 1;
        }
        true
    }
}