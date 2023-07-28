impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        
        let mut c = 0;
        let mut r = 0;
        let mut p = 0;
        for i in s.bytes() {
            if i == p {
                c += 1;
            } else {
                r = (r + (1 + c) * c / 2) % 1_000_000_007;
                c = 1;
                p = i;
            }
        }
        (r + (1 + c) * c / 2) as i32 % 1_000_000_007
    }
}