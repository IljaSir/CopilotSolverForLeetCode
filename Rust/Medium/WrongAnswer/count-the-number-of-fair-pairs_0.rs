impl Solution {
    pub fn count_fair_pairs(nums: Vec<i32>, lower: i32, upper: i32) -> i64 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        let mut sum = 0;
        map.insert(0, 1);
        for i in 0..nums.len() {
            sum += nums[i];
            for j in lower..upper + 1 {
                if let Some(&v) = map.get(&(sum - j)) {
                    count += v;
                }
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        count as i64
    }
}