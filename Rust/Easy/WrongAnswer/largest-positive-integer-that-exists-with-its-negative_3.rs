impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        let mut max = 0;
        for i in nums {
            if i > 0 {
                set.insert(i);
                max = max.max(i);
            }
        }
        for i in 1..=max {
            if !set.contains(&i) {
                return -i as i32;
            }
        }
        -1
    }
}