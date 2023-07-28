impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut mask = 0;
        for i in (0..30).rev() {
            mask |= 1 << i;
            let mut st = std::collections::HashSet::new();
            for &num in nums.iter() {
                st.insert(num & mask);
            }
            let tmp = ans | (1 << i);
            for prefix in st {
                if st.contains(&(prefix ^ tmp)) {
                    ans = tmp;
                    break;
                }
            }
        }
        ans
    }
}