impl Solution {
    pub fn min_number_of_frogs(croak_of_frogs: String) -> i32 {
        
        let mut cnt = [0; 5];
        let mut res = 0;
        for c in croak_of_frogs.chars() {
            let idx = match c {
                'c' => 0,
                'r' => 1,
                'o' => 2,
                'a' => 3,
                'k' => 4,
                _ => unreachable!(),
            };
            if idx == 0 {
                res = res.max(++cnt[0]);
            } else {
                if cnt[idx - 1] <= 0 {
                    return -1;
                }
                cnt[idx - 1] -= 1;
            }
            cnt[idx] += 1;
        }
        if cnt.iter().all(|&x| x == 0) {
            res
        } else {
            -1
        }
    }
}