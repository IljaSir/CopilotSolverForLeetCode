impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        let mut sum = 0;
        let mut max = 0;
        for (i, &num) in nums.iter().enumerate() {
            if num == 0 {
                sum -= 1;
            } else {
                sum += 1;
            }
            if sum == 0 {
                max = i + 1;
            } else if let Some(&prev) = map.get(&sum) {
                max = max.max(i - prev);
            } else {
                map.insert(sum, i);
            }
        }
        max as i32
    }
}