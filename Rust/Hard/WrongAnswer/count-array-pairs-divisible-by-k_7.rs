impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut m = std::collections::HashMap::new();
        let mut res = 0;
        for n in nums {
            let r = n % k;
            if r == 0 {
                res += m.get(&0).unwrap_or(&0);
            } else {
                res += m.get(&(k - r)).unwrap_or(&0);
            }
            *m.entry(r).or_insert(0) += 1;
        }
        res
    }
}