impl Solution {
    pub fn flip_lights(n: i32, presses: i32) -> i32 {
        

        let n = n as usize;
        let presses = presses as usize;
        let mut cnt = 0;
        for i in 0..16 {
            let mut v = vec![true; n];
            if i & 1 != 0 {
                for j in 0..n {
                    v[j] = !v[j];
                }
            }
            if i & 2 != 0 {
                for j in 0..n {
                    if j % 2 == 0 {
                        v[j] = !v[j];
                    }
                }
            }
            if i & 4 != 0 {
                for j in 0..n {
                    if j % 2 == 1 {
                        v[j] = !v[j];
                    }
                }
            }
            if i & 8 != 0 {
                for j in 0..n {
                    if j % 3 == 0 {
                        v[j] = !v[j];
                    }
                }
            }
            cnt += 1;
            for j in 1..=presses {
                let mut ok = true;
                for k in 0..n {
                    if v[k] != v[(k + j) % n] {
                        ok = false;
                        break;
                    }
                }
                if ok {
                    cnt += 1;
                }
            }
        }
        cnt
    }
}