impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        
        let mut n = n;
        let mut k = k;
        let mut ans = String::new();
        let mut nums = (1..=n).collect::<Vec<i32>>();
        let mut fac = (1..=n).fold(1, |a, b| a * b);
        for i in 0..n {
            fac /= n - i;
            let mut j = (k - 1) / fac;
            k -= j * fac;
            ans.push((nums[j as usize] + '0' as i32) as u8 as char);
            nums.remove(j as usize);
        }
        ans
    }
}