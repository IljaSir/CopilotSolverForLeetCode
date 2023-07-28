impl Solution {
    pub fn sum_of_unique(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        for i in nums {
            let count = map.entry(i).or_insert(0);
            *count += 1;
        }
        for (k, v) in map {
            if v == 1 {
                sum += k;
            }
        }
        sum
    }
}