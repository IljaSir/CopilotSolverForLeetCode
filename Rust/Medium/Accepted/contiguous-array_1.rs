impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        let mut count = 0;
        let mut max = 0;
        map.insert(0, -1);
        for (i, &num) in nums.iter().enumerate() {
            count += if num == 0 { -1 } else { 1 };
            if let Some(&j) = map.get(&count) {
                max = max.max(i as i32 - j);
            } else {
                map.insert(count, i as i32);
            }
        }
        max
    }
}