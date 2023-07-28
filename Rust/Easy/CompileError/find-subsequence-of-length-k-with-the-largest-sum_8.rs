impl Solution {
    pub fn max_subsequence(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut ans = vec![];
        let k = k as usize;
        let n = nums.len();
        let mut st = Vec::with_capacity(n);
        let mut i = 0;
        while i < n {
            while !st.is_empty() && st.len() + n - i > k && st[st.len() - 1] < nums[i] {
                st.pop();
            }
            if st.len() < k {
                st.push(nums[i]);
            }
            i += 1;
        }
        st
    }
}