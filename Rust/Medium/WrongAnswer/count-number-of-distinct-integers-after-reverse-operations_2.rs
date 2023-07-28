impl Solution {
    pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for num in nums {
            let mut x = num;
            let mut y = 0;
            while x > 0 {
                y = y * 10 + x % 10;
                x /= 10;
            }
            set.insert(y);
        }
        set.len() as i32
    }
}