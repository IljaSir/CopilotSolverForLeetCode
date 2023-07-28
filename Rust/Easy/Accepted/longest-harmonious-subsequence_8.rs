impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        
        let mut counter = std::collections::HashMap::new();
        for num in nums {
            *counter.entry(num).or_insert(0) += 1;
        }
        let mut max = 0;
        for (k, v) in counter.iter() {
            if let Some(w) = counter.get(&(k + 1)) {
                max = std::cmp::max(max, v + w);
            }
        }
        max
    }
}