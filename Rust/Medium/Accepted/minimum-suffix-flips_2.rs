impl Solution {
    pub fn min_flips(target: String) -> i32 {
        
        let mut last = '0';
        let mut count = 0;
        for c in target.chars() {
            if c != last {
                last = c;
                count += 1;
            }
        }
        count
    }
}