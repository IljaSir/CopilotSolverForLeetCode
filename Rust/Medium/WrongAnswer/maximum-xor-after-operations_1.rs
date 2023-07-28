impl Solution {
    pub fn maximum_xor(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut mask = 0;
        for i in (0..30).rev() {
            mask |= 1 << i;
            let mut s = std::collections::HashSet::new();
            for num in &nums {
                s.insert(num & mask);
            }
            let t = ans | (1 << i);
            for prefix in &s {
                if s.contains(&(t ^ prefix)) {
                    ans = t;
                    break;
                }
            }
        }
        ans
    }
}