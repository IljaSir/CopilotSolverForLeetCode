impl Solution {
    pub fn min_flips(target: String) -> i32 {
        
        let mut flip = 0;
        let mut prev = '0';
        for c in target.chars() {
            if c != prev {
                prev = c;
                flip += 1;
            }
        }
        flip
    }
}