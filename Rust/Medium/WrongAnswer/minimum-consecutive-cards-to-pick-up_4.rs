impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        
        let mut freq = vec![0; 1000001];
        for &card in &cards {
            freq[card as usize] += 1;
        }
        let mut ans = cards.len();
        for i in 0..freq.len() {
            if freq[i] > 1 {
                ans = ans.min(freq[i]);
            }
        }
        if ans == cards.len() {
            -1
        } else {
            ans as i32
        }
    }
}