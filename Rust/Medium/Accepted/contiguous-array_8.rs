impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        

        let mut res = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for (i, &num) in nums.iter().enumerate() {
            count += if num == 0 { -1 } else { 1 };
            if count == 0 {
                res = i + 1;
            } else if let Some(&j) = map.get(&count) {
                res = res.max(i - j);
            } else {
                map.insert(count, i);
            }
        }
        res as i32
    }
}