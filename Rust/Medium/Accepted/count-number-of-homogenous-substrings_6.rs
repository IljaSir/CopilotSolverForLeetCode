impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        
        let mut res = 0;
        let mut count = 1;
        let mut prev = ' ';
        let mut modu = 1000000007;
        for c in s.chars() {
            if c == prev {
                count += 1;
            } else {
                count = 1;
                prev = c;
            }
            res = (res + count) % modu;
        }
        res
    }
}