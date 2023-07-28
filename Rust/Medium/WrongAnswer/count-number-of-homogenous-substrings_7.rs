impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        
        let modu = 1_000_000_007;
        let mut count = 0;
        let mut prev = 'a';
        let mut num = 0;
        for c in s.chars() {
            if c != prev {
                prev = c;
                num = 0;
            }
            num += 1;
            count += num;
        }
        (count % modu) as i32
    }
}