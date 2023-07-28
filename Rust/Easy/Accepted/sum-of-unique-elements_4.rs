impl Solution {
    pub fn sum_of_unique(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        for &n in nums.iter() {
            *map.entry(n).or_insert(0) += 1;
        }
        for (k, v) in map {
            if v == 1 {
                res += k;
            }
        }
        res
    }
}