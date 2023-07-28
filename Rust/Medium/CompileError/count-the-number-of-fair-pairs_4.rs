impl Solution {
    pub fn count_fair_pairs(nums: Vec<i32>, lower: i32, upper: i32) -> i64 {
        
        let mut sum = 0;
        let mut count = 0;
        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for num in nums {
            sum += num;
            for i in lower..=upper {
                if let Some(&v) = map.get(&(sum - i)) {
                    count += v;
                }
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        count
    }
}