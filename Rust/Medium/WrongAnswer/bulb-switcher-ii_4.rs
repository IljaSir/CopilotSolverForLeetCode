impl Solution {
    pub fn flip_lights(n: i32, presses: i32) -> i32 {
        

        let n = n as usize;
        let presses = presses as usize;
        let mut ans = 0;
        let mut vis = vec![false; 16];
        for i in 0..16 {
            if vis[i] { continue; }
            if presses >= 3 {
                ans += 1;
            } else {
                let mut v = vec![false; n];
                for j in 0..n {
                    if i & 1 << 0 > 0 { v[j] = !v[j]; }
                    if i & 1 << 1 > 0 && j % 2 == 0 { v[j] = !v[j]; }
                    if i & 1 << 2 > 0 && j % 2 == 1 { v[j] = !v[j]; }
                    if i & 1 << 3 > 0 && j % 3 == 0 { v[j] = !v[j]; }
                }
                let mut idx = 0;
                for j in 0..n {
                    idx |= (v[j] as usize) << j;
                }
                vis[idx] = true;
                ans += 1;
            }
        }
        ans
    }
}