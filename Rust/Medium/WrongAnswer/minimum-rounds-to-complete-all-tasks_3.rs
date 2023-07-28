impl Solution {
    pub fn minimum_rounds(tasks: Vec<i32>) -> i32 {
        
        let mut cnt = vec![0; 32];
        for &t in tasks.iter() {
            let mut x = t;
            if x % 2 == 1 {
                x += 1;
            }
            let mut i = 0;
            while x > 0 {
                x >>= 1;
                i += 1;
            }
            cnt[i] += 1;
        }
        let mut max = 0;
        for i in 0..32 {
            if cnt[i] == 0 {
                continue;
            }
            if cnt[i] % 2 == 1 {
                cnt[i] += 1;
            }
            let mut x = cnt[i];
            let mut j = 0;
            while x > 0 {
                x >>= 1;
                j += 1;
            }
            max = std::cmp::max(max, j);
        }
        max
    }
}