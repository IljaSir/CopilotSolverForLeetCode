impl Solution {
    pub fn has_groups_size_x(deck: Vec<i32>) -> bool {
        
        let mut count: Vec<i32> = vec![0; 10000];
        for i in 0..deck.len() {
            count[deck[i] as usize] += 1;
        }
        let mut g = 0;
        for i in 0..10000 {
            if count[i] > 0 {
                g = gcd(g, count[i]);
            }
        }
        g > 1
    }
}