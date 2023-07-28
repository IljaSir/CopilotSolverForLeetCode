impl Solution {
    pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut res = 0;
        for n in nums {
            let r = n.to_string().chars().rev().collect::<String>().parse::<i32>().unwrap();
            let diff = (n - r).abs();
            let count = map.entry(diff).or_insert(0);
            *count += 1;
            res += *count - 1;
            res %= 1_000_000_007;
        }
        res
    }
}