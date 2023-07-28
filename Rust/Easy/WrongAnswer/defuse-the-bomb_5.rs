impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut ret = Vec::with_capacity(code.len());
        let mut sum = 0;
        if k == 0 {
            for _ in 0..code.len() {
                ret.push(0);
            }
            return ret;
        }
        let mut i = 0;
        let mut j = 0;
        if k > 0 {
            while i < k as usize {
                sum += code[i];
                i += 1;
            }
            ret.push(sum);
            for _ in 0..code.len() - 1 {
                sum += code[i];
                sum -= code[j];
                ret.push(sum);
                i += 1;
                j += 1;
                if i == code.len() {
                    i = 0;
                }
                if j == code.len() {
                    j = 0;
                }
            }
        } else {
            while i < (-k) as usize {
                sum += code[code.len() - 1 - i];
                i += 1;
            }
            ret.push(sum);
            for _ in 0..code.len() - 1 {
                sum += code[code.len() - 1 - i];
                sum -= code[code.len() - 1 - j];
                ret.push(sum);
                i += 1;
                j += 1;
                if i == code.len() {
                    i = 0;
                }
                if j == code.len() {
                    j = 0;
                }
            }
        }
        ret
    }
}