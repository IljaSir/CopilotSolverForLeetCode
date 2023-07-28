impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        
        let mut counter = vec![0; 1000001];
        for &card in &cards {
            counter[card as usize] += 1;
        }
        let mut result = i32::MAX;
        for &count in &counter {
            if count >= 2 {
                result = result.min(count);
            }
        }
        if result == i32::MAX {
            -1
        } else {
            cards.len() as i32 - result
        }
    }
}