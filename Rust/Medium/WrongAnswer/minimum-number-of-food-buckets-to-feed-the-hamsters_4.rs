impl Solution {
    pub fn minimum_buckets(hamsters: String) -> i32 {
        
        let mut ans = 0;
        let mut l = 0;
        let mut r = 0;
        for c in hamsters.chars() {
            if c == 'H' {
                if l == 0 {
                    ans += 1;
                    l = 1;
                }
                r = 0;
            } else {
                if l == 0 && r == 0 {
                    ans += 1;
                    l = 1;
                } else if l == 1 && r == 1 {
                    ans += 1;
                    l = 0;
                }
                r = 1;
            }
        }
        ans
    }
}