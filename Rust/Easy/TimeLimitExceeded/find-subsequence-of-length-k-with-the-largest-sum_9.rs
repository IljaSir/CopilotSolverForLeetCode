impl Solution {
    pub fn max_subsequence(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = vec![0; k as usize];
        let mut max = 0;
        let mut cur = 0;
        let mut i = 0;
        let mut j = 0;
        let mut n = nums.len();
        let mut stack = vec![];
        while i < n {
            while j < n && j - i < k as usize {
                cur += nums[j];
                while !stack.is_empty() && stack.last().unwrap() < &nums[j] {
                    cur -= stack.pop().unwrap();
                }
                stack.push(nums[j]);
                j += 1;
            }
            if j - i == k as usize {
                if cur > max {
                    max = cur;
                    res = stack.clone();
                }
                cur -= stack.pop().unwrap();
                i += 1;
            }
        }
        res
    }
}