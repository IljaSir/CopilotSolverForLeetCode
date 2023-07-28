impl Solution {
    pub fn find_pairs(nums: Vec<i32>, k: i32) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        for i in nums {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut res = 0;
        for (i, j) in map.iter() {
            if k == 0 {
                if *j > 1 {
                    res += 1;
                }
            } else {
                if map.contains_key(&(i + k)) {
                    res += 1;
                }
            }
        }
        res
    }
}