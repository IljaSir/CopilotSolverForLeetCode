impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut last = -1;
        for &c in cards.iter() {
            if c != last {
                last = c;
                count = 0;
            }
            count += 1;
            if count == 2 {
                return 2;
            }
        }
        -1
    }
}