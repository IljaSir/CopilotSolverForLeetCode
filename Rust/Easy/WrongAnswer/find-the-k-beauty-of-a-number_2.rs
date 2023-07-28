impl Solution {
    pub fn divisor_substrings(num: i32, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut s = num.to_string();
        for i in 0..(s.len() - k as usize + 1) {
            let n: i32 = s[i..i + k as usize].parse().unwrap();
            if n % num == 0 {
                ans += 1;
            }
        }
        ans
    }
}