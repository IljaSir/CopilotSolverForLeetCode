impl Solution {
    pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        let mut result = 0;
        for num in nums {
            let rev = num.to_string().chars().rev().collect::<String>().parse::<i32>().unwrap();
            let diff = (num - rev).abs();
            *map.entry(diff).or_insert(0) += 1;
        }
        for val in map.values() {
            result += val * (val - 1) / 2;
        }
        result as i32 % 1000000007
    }
}