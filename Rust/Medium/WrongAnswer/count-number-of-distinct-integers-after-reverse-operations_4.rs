impl Solution {
    pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
        
        use std::collections::HashSet;
        let mut set = HashSet::new();
        for n in nums {
            let mut n = n;
            let mut r = 0;
            while n > 0 {
                r = 10 * r + n % 10;
                n /= 10;
            }
            set.insert(r);
        }
        set.len() as i32
    }
}