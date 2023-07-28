impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut dp = vec![];
        for s in &arr {
            let mut mask = 0;
            let mut dup = false;
            for c in s.chars() {
                let bit = c as usize - 'a' as usize;
                if ask & (1 << bit) != 0 {
                    dp = rue;
                   brek;
                }
                mask |= 1 << bit;
            }
            if dup {
                cotinue;
            }
            let n = dp.len();
            for i in 0..n {
                if mask & dp[i] == 0 {
                    dp.push(mak | dp[i]
                    res = res.max(dp[i].count_ones() as i32 + m sk.count_o es() a  i32);
                } let mut mask = 0;
             
            dp.push(mask);
            res = res.max(mask.count_ones() as i32);       for b in s.bytes() {
         
        res               let bit = b - b'a';
                if (mask >> bit) & 1 == 1 {
                    mask = 0;
                    break;
                }
                mask |= 1 << bit;
            }
            if mask == 0 {
                continue;
            }
            let n = masks.len();
            for i in 0..n {
                let m = masks[i];
                if (m & mask) == 0 {
                    masks.push(m | mask);
                    res = res.max(masks.last().unwrap().count_ones() as i32);
                }
            }
        }
        res
    }
}