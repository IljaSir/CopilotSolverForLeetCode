impl Solution {
    pub fn valid_utf8(data: Vec<i32>) -> bool {
        

        let mut i = 0;
        while i < data.len() {
            let mut bits = data[i].leading_zeros() as i32;
            if bits > 4 || bits == 1 {
                return false;
            }
            if bits == 0 {
                i += 1;
                continue;
            }
            for j in 1..bits {
                if i + j as usize >= data.len() || data[i + j as usize].leading_zeros() != 1 {
                    return false;
                }
            }
            i += bits as usize;
        }
        true
    }
}