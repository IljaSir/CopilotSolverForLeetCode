impl Solution {
    pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut result = 0;
        let mod_num = 1000000007;
        for num in nums {
            let rev_num = num.to_string().chars().rev().collect::<String>().parse::<i32>().unwrap();
            let diff = num - rev_num;
            let count = map.entry(diff).or_insert(0);
            result = (result + *count) % mod_num;
            *count += 1;
        }
        result
    }
}