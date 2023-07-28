impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for num in nums {
            let count = map.entry(num).or_insert(0);
            *count += 1;
        }
        let mut max = 0;
        let mut max_num = 0;
        for (num, count) in map {
            if count > max {
                max = count;
                max_num = num;
            }
        }
        max_num
    }
}