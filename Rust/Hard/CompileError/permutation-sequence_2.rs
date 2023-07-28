impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        
        let mut nums = vec![];
        let mut factorial = vec![1; n as usize];
        for i in 1..n as usize {
            factorial[i] = factorial[i - 1] * i;
            nums.push((i + 1) as i32);
        }
        nums.push(1);
        let mut k = k - 1;
        let mut ans = String::new();
        for i in (0..n as usize).rev() {
            let idx = (k / factorial[i]) as usize;
            k %= factorial[i];
            ans.push(std::char::from_digit(nums[idx] as u32, 10).unwrap());
            nums.remove(idx);
        }
        ans
    }
}