impl Solution {
    pub fn max_operations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for num in nums {
            let pair = k - num;
            if let Some(value) = map.get(&pair) {
                if *value > 0 {
                    map.insert(pair, value - 1);
                    count += 1;
                } else {
                    map.insert(num, map.get(&num).unwrap_or(&0) + 1);
                }
            } else {
                map.insert(num, map.get(&num).unwrap_or(&0) + 1);
            }
        }
        count
    }
}