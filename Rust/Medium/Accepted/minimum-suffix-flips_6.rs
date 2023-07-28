impl Solution {
    pub fn min_flips(target: String) -> i32 {
        
        let mut result = 0;
        let mut state = '0';
        for c in target.chars() {
            if c != state {
                result += 1;
                state = c;
            }
        }
        result
    }
}