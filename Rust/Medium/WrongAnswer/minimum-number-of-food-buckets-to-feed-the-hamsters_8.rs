impl Solution {
    pub fn minimum_buckets(hamsters: String) -> i32 {
        
        let mut count: i32 = 0;
        let mut pre: i32 = 0;
        for (idx, c) in hamsters.chars().enumerate() {
            if c == 'H' {
                count += 1;
                if idx as i32 - pre > 1 {
                    count += 1;
                }
                pre = idx as i32;
            }
        }
        count
    }
}