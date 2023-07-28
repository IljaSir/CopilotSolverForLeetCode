impl Solution {
    pub fn find_maximum_xor(nums: Vec<i32>) -> i32 {
        

        let mut ans = 0;
        let mut mask = 0;
        for i in (0..31).rev() {
            mask |= 1 << i;
            let mut set = std::collections::HashSet::new();
            for &num in &nums {
                set.insert(num & mask);
            }
            let tmp = ans | 1 << i;
            for &pre in &set {
                if set.contains(&(pre ^ tmp)) {
                    ans = tmp;
                    break;
                }
            }
        }
        ans
    }
}