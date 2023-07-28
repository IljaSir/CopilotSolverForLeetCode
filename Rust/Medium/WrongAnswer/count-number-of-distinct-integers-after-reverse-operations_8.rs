impl Solution {
    pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut set = std::collections::HashSet::new();
        for i in nums.iter_mut() {
            let mut n = 0;
            let mut j = *i;
            while j > 0 {
                n = n * 10 + j % 10;
                j /= 10;
            }
            set.insert(n);
        }
        set.len() as i32
    }
}