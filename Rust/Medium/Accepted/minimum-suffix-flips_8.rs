impl Solution {
    pub fn min_flips(target: String) -> i32 {
        
        let mut count = 0;
        let mut flip = false;
        for c in target.chars() {
            if c == '1' && !flip {
                count += 1;
                flip = true;
            } else if c == '0' && flip {
                count += 1;
                flip = false;
            }
        }
        count
    }
}