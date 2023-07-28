impl Solution {
    pub fn min_flips(target: String) -> i32 {
        
        let mut res = 0;
        let mut cur = '0';
        for c in target.chars() {
            if c != cur {
                res += 1;
                cur = c;
            }
        }
        res
    }
}