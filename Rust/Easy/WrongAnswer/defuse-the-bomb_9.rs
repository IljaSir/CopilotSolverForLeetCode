impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut ans = vec![0; code.len()];
        if k == 0 {
            return ans;
        }
        let mut sum = 0;
        let n = code.len();
        let k = k.abs() as usize;
        for i in 0..k {
            sum += code[(i + 1) % n];
        }
        for i in 0..n {
            ans[i] = sum;
            sum -= code[(i + 1) % n];
            sum += code[(i + 1 + k) % n];
        }
        if k as i32 > 0 {
            ans
        } else {
            ans.iter().map(|&x| -x).collect()
        }
    }
}