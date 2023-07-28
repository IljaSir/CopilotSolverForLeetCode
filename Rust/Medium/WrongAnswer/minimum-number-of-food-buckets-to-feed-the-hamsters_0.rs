impl Solution {
    pub fn minimum_buckets(hamsters: String) -> i32 {
        
        let mut ans = 0;
        let mut count = 0;
        for c in hamsters.chars() {
            if c == 'H' {
                ans += (count + 1) / 2;
                count = 0;
            } else {
                count += 1;
            }
        }
        if count > 0 {
            ans += (count + 1) / 2;
        }
        ans
    }
}