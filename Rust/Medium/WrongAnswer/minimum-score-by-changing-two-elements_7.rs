impl Solution {
    pub fn minimize_sum(nums: Vec<i32>) -> i32 {
        
        let mut a = nums.clone();
        a.sort();
        let mut b = a.clone();
        let mut c = a.clone();
        let mut d = a.clone();
        let n = a.len();
        a[1] = a[0];
        b[n-2] = b[n-1];
        c[1] = c[0];
        d[n-2] = d[n-1];
        let mut ans = std::i32::MAX;
        for i in 0..n-1 {
            ans = ans.min((a[i+1]-a[i]).abs() + (b[i+1]-b[i]).abs());
            ans = ans.min((c[i+1]-c[i]).abs() + (d[i+1]-d[i]).abs());
        }
        ans
    }
}