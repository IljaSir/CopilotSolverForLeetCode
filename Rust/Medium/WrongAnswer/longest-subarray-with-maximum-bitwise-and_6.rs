impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut mask = -1;
        let n = nums.len();
        for i in 0..30 {
            let mut set = std::collections::HashSet::new();
            for &x in &nums {
                set.insert(x & mask);
            }
            let mut found = false;
            let t = ans | (1 << i);
            for &x in &set {
                if set.contains(&(x ^ t)) {
                    ans = t;
                    found = true;
                    break;
                }
            }
            if !found {
                mask &= !(1 << i);
            }
        }
        ans
    }
}