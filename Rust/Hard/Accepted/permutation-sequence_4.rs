impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        
        let mut n = n;
        let mut k = k;
        let mut fac = vec![1; n as usize];
        let mut nums = vec![];
        for i in 1..n {
            fac[i as usize] = fac[(i - 1) as usize] * i;
            nums.push(i);
        }
        nums.push(n);
        let mut ans = String::new();
        k -= 1;
        for i in (0..n).rev() {
            let j = (k / fac[i as usize]) as usize;
            k %= fac[i as usize];
            ans.push((nums[j] + '0' as i32) as u8 as char);
            nums.remove(j);
        }
        ans
    }
}