impl Solution {
    pub fn max_operations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut ans = 0;
        for n in nums {
            let t = k - n;
            match map.get_mut(&t) {
                Some(v) => {
                    if v > &mut 0 {
                        *v -= 1;
                        ans += 1;
                    } else {
                        *map.entry(n).or_insert(0) += 1;
                    }
                }
                None => {
                    *map.entry(n).or_insert(0) += 1;
                }
            }
        }
        ans
    }
}