impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        

        let mut sum = 0;
        let mut max_len = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, -1);
        for (i, n) in nums.iter().enumerate() {
            sum += if *n == 0 { -1 } else { 1 };
            if let Some(&j) = map.get(&sum) {
                max_len = std::cmp::max(max_len, (i as i32) - j);
            } else {
                map.insert(sum, i as i32);
            }
        }
        max_len
    }
}