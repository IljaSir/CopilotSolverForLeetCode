impl Solution {
    pub fn min_flips(target: String) -> i32 {
        
        let mut last: char = '0';
        let mut count: i32 = 0;
        for c in target.chars() {
            if c != last {
                count += 1;
                last = c;
            }
        }
        count
    }
}