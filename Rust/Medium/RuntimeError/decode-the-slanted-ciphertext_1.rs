impl Solution {
    pub fn decode_ciphertext(encoded_text: String, rows: i32) -> String {
        
        let n = encoded_text.len();
        let cols = n / rows as usize;
        let mut res = vec![vec![' '; cols]; rows as usize];
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        while i < n {
            // first row
            while j < cols && i < n {
                res[k][j] = encoded_text.chars().nth(i).unwrap();
                i += 1;
                j += 1;
            }
            k += 1;
            j -= 1;
            // last row
            while k < rows as usize - 1 && i < n {
                res[k][j] = encoded_text.chars().nth(i).unwrap();
                i += 1;
                k += 1;
                j -= 1;
            }
            k += 1;
            j += 1;
        }
        let mut ret = String::new();
        for i in 0..rows as usize {
            for j in 0..cols {
                if res[i][j] != ' ' {
                    ret.push(res[i][j]);
                }
            }
        }
        ret
    }
}