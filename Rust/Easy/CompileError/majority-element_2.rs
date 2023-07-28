impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for num in nums {
            let count = map.entry(num).or_insert(0);
            *count += 1;
            if *count > nums.len() / 2 {
                return num;
            }
        }
        0
    }
}