impl Solution {
    pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
        
        let mut even = Vec::new();
        for num in nums {
            if num % 2 == 0 {
                even.push(num);
            }
        }
        let mut map = std::collections::HashMap::new();
        for num in even {
            let count = map.entry(num).or_insert(0);
            *count += 1;
        }
        let mut max = 0;
        let mut result = -1;
        for (key, value) in map {
            if value > max || (value == max && key < result) {
                max = value;
                result = key;
            }
        }
        result
    }
}