impl Solution {
    pub fn max_total_fruits(fruits: Vec<Vec<i32>>, start_pos: i32, k: i32) -> i32 {
        
        let mut f = fruits;
        let mut s = start_pos;
        let mut k = k;
        let mut res = 0;
        let mut cur = 0;
        let mut i = 0;
        let mut j = 0;
        let mut n = f.len();
        while i < n {
            let mut t = 0;
            while j < n && (t + f[j][0] - f[i][0]) <= k {
                t += f[j][0] - f[i][0];
                if f[i][0] <= s && s <= f[j][0] {
                    cur += f[j][1];
                }
                j += 1;
            }
            res = res.max(cur);
            if j == n {
                break;
            }
            while i < j && (t + f[j][0] - f[i][0]) > k {
                t += f[j][0] - f[i][0];
                if f[i][0] <= s && s <= f[j][0] {
                    cur -= f[i][1];
                }
                i += 1;
            }
        }
        res
    }
}