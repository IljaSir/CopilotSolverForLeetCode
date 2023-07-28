impl Solution {
    pub fn maximum_xor(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut mask = 0;
        for i in (0..=30).rev() {
            mask |= 1 << i;
            let mut s = std::collections::HashSet::new();
            for n in nums.iter() {
                s.insert(n & mask);
            }
            let cand = ans | 1 << i;
            for p in s.iter() {
                if s.contains(&(p ^ cand)) {
                    ans = cand;
                    break;
                }
            }
        }
        ans
    }
}