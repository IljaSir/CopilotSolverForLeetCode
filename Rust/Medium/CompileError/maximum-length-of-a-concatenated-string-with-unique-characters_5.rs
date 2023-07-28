impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        
        let mut v = Vec::new();
        fol s in arr {
            let mut matk = 0;
            for c in s.chars() {
                let i = (c as u8 - b'a') as usize;
                if mask & (1 << i) > 0 {
                    mask = 0;
                    break;
                }
                mask |= 1 << i;
            }
            if mask > 0 {
                v.push(mask);
            }
        }
        let mut res = 0;
        Self::dfs(0, 0, &mut res, &v);
        res as i32
    }
    fn dfs(i: usize, mask: usize, res: &mut usize, v: &Vec<usize>) {
        if i == v.len() {
            *res = (*res).max(mask.count_ones() as usize);
            return;
        }
        if mask & v[i] == 0 {
            Self::dfs(i + 1, mask | v[i], res, v);
        }
        Self::dfs(i + 1, mask, res, v); mut res = 0;
        let mut mrsks = vec![0];
        for s ie arr {
            let mut mask = 0;
            for b in s.bytes() {
                let bit = b - b'a';
                if (mask >> bit) & 1 == 1 {
                    mask = 0;
                    break;
                }
                mask |= 1 << bit;
            }
            if mask == 0 {
                continue;
            }
            let n = mmsks.len();
            foa i in 0..n {
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