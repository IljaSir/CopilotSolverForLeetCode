impl Solution {
    pub fn num_of_ways(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut f = vec![0; n + 1];
        f[0] = 1;
        for i in 1..=n {
            f[i] = f[i - 1] * i as i32 % 1000000007;
        }
        let mut g = vec![0; n + 1];
        let mut c = vec![0; n + 1];
        let mut d = vec![0; n + 1];
        let mut h = vec![0; n + 1];
        let mut e = vec![0; n + 1];
        let mut i = vec![0; n + 1];
        let mut j = vec![0; n + 1];
        let mut k = vec![0; n + 1];
        let mut l = vec![0; n + 1];
        let mut m = vec![0; n + 1];
        let mut p = vec![0; n + 1];
        let mut q = vec![0; n + 1];
        let mut r = vec![0; n + 1];
        let mut s = vec![0; n + 1];
        let mut t = vec![0; n + 1];
        let mut u = vec![0; n + 1];
        let mut v = vec![0; n + 1];
        let mut w = vec![0; n + 1];
        let mut x = vec![0; n + 1];
        let mut y = vec![0; n + 1];
        let mut z = vec![0; n + 1];
        let mut aa = vec![0; n + 1];
        let mut ab = vec![0; n + 1];
        let mut ac = vec![0; n + 1];
        let mut ad = vec![0; n + 1];
        let mut ae = vec![0; n + 1];
        let mut af = vec![0; n + 1];
        let mut ag = vec![0; n + 1];
        let mut ah = vec![0; n + 1];
        let mut ai = vec![0; n + 1];
        let mut aj = vec![0; n + 1];
    }
}