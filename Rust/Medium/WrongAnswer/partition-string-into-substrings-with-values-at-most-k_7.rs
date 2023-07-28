impl Solution {
    pub fn minimum_partition(s: String, k: i32) -> i32 {
        
        let mut max: i32 = 0;
        let mut res: i32 = 0;
        let mut cur: i32 = 0;
        for c in s.chars() {
            let v = (c as u8 - '0' as u8) as i32;
            max = max.max(v);
            cur += v;
            if cur > k {
                res += 1;
                cur = max;
                max = 0;
            }
        }
        res + 1
    }
}