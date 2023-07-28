impl Solution {
    pub fn sum_zero(n: i32) -> Vec<i32> {
        
        let mut ans: Vec<i32> = vec![];
        let mut i = 1;
        while i <= n {
            ans.push(i);
            ans.push(-i);
            i += 1;
        }
        ans
    }
}