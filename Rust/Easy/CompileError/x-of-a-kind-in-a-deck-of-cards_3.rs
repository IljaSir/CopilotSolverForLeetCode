impl Solution {
    pub fn has_groups_size_x(deck: Vec<i32>) -> bool {
        
        let mut counts = [0; 10000];
        for &d in deck.iter() {
            counts[d as usize] += 1;
        }
        let mut x = 0;
        for &c in counts.iter() {
            if c > 0 {
                x = gcd(x, c);
                if x == 1 {
                    return false;
                }
            }
        }
        true
    }
}