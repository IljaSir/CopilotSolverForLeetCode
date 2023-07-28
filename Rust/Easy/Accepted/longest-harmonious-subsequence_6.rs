impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in nums {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut res = 0;
        for (k, v) in map.iter() {
            if let Some(v2) = map.get(&(k+1)) {
                res = res.max(v + v2);
            }
        }
        res
    }
}