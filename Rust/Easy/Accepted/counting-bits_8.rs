impl Solution {
    pub fn count_bits(n: i32) -> Vec<i32> {
        
        let mut ans = Vec::new();
        ans.push(0);
        for i in 1..(n+1) {
            ans.push(ans[(i & (i - 1)) as usize] + 1);
        }
        ans
    }
}