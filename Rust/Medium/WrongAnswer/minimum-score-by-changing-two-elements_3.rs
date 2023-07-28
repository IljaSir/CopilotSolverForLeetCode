impl Solution {
    pub fn minimize_sum(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut v = nums;
        v.sort();
        let mut a = v[0];
        let mut b = v[1];
        let mut c = v[n - 2];
        let mut d = v[n - 1];
        let mut ans = (b - a).abs() + (c - d).abs();
        for i in 1..n-2 {
            a = v[i];
            b = v[i+1];
            ans = ans.min((a - c).abs() + (b - d).abs());
            ans = ans.min((a - d).abs() + (b - c).abs());
        }
        ans
    }
}