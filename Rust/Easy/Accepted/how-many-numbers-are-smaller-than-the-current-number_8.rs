impl Solution {
    pub fn smaller_numbers_than_current(nums: Vec<i32>) -> Vec<i32> {
        
        let mut sorted = nums.clone();
        sorted.sort();
        let mut map = std::collections::HashMap::new();
        for (i, num) in sorted.iter().enumerate() {
            if !map.contains_key(num) {
                map.insert(num, i as i32);
            }
        }
        nums.iter().map(|num| map[num]).collect()
    }
}