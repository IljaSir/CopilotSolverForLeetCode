impl Solution {
    pub fn minimum_buckets(hamsters: String) -> i32 {
        
        let mut cnt = 0;
        let mut res = 0;
        for c in hamsters.chars() {
            if c == 'H' {
                if cnt == 0 {
                    res += 1;
                } else {
                    cnt -= 1;
                }
            } else {
                cnt += 1;
            }
        }
        if cnt > 0 {
            -1
        } else {
            res
        }
    }
}