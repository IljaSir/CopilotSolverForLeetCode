impl Solution {
    pub fn sum_of_unique(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for num in nums {
            *map.entry(num).or_insert(0) += 1;
        }
        map.iter().filter(|(_, &v)| v == 1).map(|(k, _)| k).sum()
    }
}