impl Solution {
    pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut res = 0;
        let modu = 1_000_000_007;
        for &n in nums.iter() {
            let key = n - n.to_string().chars().rev().collect::<String>().parse::<i32>().unwrap();
            res = (res + map.entry(key).or_insert(0) + 1) % modu;
            *map.get_mut(&key).unwrap() += 1;
        }
        res
    }
}