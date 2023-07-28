impl Solution {
    pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for n in nums {
            set.insert(n);
            let mut rev = 0;
            let mut m = n;
            while m > 0 {
                rev = rev * 10 + m % 10;
                m /= 10;
            }
            set.insert(rev);
        }
        set.len() as i32
    }
}