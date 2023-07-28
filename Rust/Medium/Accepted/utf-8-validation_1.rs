impl Solution {
    pub fn valid_utf8(data: Vec<i32>) -> bool {
        

        let mut i = 0;
        while i < data.len() {
            let mut b = data[i];
            let mut mask = 1 << 7;
            let mut cnt = 0;
            while b & mask != 0 {
                b &= !mask;
                mask >>= 1;
                cnt += 1;
            }
            if cnt == 1 || cnt > 4 {
                return false;
            }
            if cnt == 0 {
                i += 1;
                continue;
            }
            for _ in 0..cnt-1 {
                i += 1;
                if i == data.len() {
                    return false;
                }
                let b = data[i];
                if b & (1 << 7) == 0 || b & (1 << 6) != 0 {
                    return false;
                }
            }
            i += 1;
        }
        true
    }
}