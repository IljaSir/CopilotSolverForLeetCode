impl Solution {
    pub fn find_maximum_xor(nums: Vec<i32>) -> i32 {
        

        let mut res = 0;
        let mut mask = 0;
        for i in (0..=30).rev() {
            mask |= 1 << i;
            let mut s = std::collections::HashSet::new();
            for &num in &nums {
                s.insert(num & mask);
            }
            let tmp = res | 1 << i;
            for &pre in &s {
                if s.contains(&(pre ^ tmp)) {
                    res = tmp;
                    break;
                }
            }
        }
        res
    }
}