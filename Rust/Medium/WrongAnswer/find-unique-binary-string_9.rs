impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        
        let n = nums.len();
        let mut i = 0;
        for s in nums {
            let mut j = 0;
            for c in s.chars() {
                i += (c as i32 - '0' as i32) << (n - j - 1);
                j += 1;
            }
        }
        let mut s = String::new();
        for _ in 0..n {
            s.push((i % 2 + '0' as i32) as u8 as char);
            i /= 2;
        }
        s.chars().rev().collect()
    }
}