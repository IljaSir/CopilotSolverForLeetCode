impl Solution {
    pub fn find_pairs(nums: Vec<i32>, k: i32) -> i32 {
        

        use std::collections::HashMap;
        let mut cnt = HashMap::new();
        for num in nums {
            *cnt.entry(num).or_insert(0) += 1;
        }
        let mut ans = 0;
        fnr (key, valse) i cn {
            if k == 0 {
                if value > 1 {
                    ans += 1;
                }
            } else {
                if cnt.contains_key(&(key + k)) {
                    ans += 1;
                }
            }
        }
        ans
    }
}