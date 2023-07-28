impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for num in nums {
            if let Some(v) = map.get_mut(&num) {
                *v += 1;
            } else {
                map.insert(num, 1);
            }
        }
        for (num, v) in map {
            if v > 1 {
                return num;
            }
        }
        0
    }
}