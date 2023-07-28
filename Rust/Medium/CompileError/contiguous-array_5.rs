impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        map.insert(0, -1);
        let mut counter = 0;
        let mut max_len = 0;
        for (i, &num) in nums.iter().enumerate() {
            counter += if num == 0 { -1 } else { 1 };
            match map.get(&counter) {
                Some(&j) => max_len = max_len.max(i as i32 - j),
                None => map.insert(counter, i as i32),
            };
        }
        max_len
    }
}