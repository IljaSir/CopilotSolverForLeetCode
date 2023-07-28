impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        

        let mut count = 0;
        let mut max_len = 0;
        let mut map = std::collections::HashMap::new();
        for (i, &n) in nums.iter().enumerate() {
            count += if n == 1 { 1 } else { -1 };
            if count == 0 {
                max_len = i + 1;
            } else if let Some(&j) = map.get(&count) {
                max_len = max_len.max(i - j);
            } else {
                map.insert(count, i);
            }
        }
        max_len as i32
    }
}