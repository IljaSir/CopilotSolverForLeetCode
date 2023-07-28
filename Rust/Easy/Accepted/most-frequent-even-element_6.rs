impl Solution {
    pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        for num in nums {
            if num % 2 == 0 {
                let count = map.entry(num).or_insert(0);
                *count += 1;
                if *count > max {
                    max = *count;
                }
            }
        }
        let mut result = -1;
        for (k, v) in map {
            if v == max {
                if result == -1 {
                    result = k;
                } else if k < result {
                    result = k;
                }
            }
        }
        result
    }
}