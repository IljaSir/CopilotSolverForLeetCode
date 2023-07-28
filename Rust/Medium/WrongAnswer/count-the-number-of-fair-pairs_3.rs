impl Solution {
    pub fn count_fair_pairs(nums: Vec<i32>, lower: i32, upper: i32) -> i64 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for (i, num) in nums.iter().enumerate() {
            for j in i + 1..nums.len() {
                if lower <= num + nums[j] && num + nums[j] <= upper {
                    count += 1;
                }
            }
            let cnt = map.entry(num).or_insert(0);
            *cnt += 1;
        }
        for (num, cnt) in map.iter() {
            if cnt > &1 {
                count += cnt * (cnt - 1) / 2;
            }
        }
        count as i64
    }
}