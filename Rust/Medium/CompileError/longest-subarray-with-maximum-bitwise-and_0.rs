impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut mask = 0;
        for i in (0..=30).rev() {
            mask |= 1 << i;
            let mut set = std::collections::HashSet::new();
            for &x in &nums {
                set.insert(x & mask);
            }
            let tmp = ans | (1 << i);
            for prefix in set {
                if set.contains(&(tmp ^ prefix)) {
                    ans = tmp;
                    break;
                }
            }
        }
        ans
    }
}