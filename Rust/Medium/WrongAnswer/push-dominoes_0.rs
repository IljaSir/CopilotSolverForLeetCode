impl Solution {
    pub fn push_dominoes(dominoes: String) -> String {
        
        let mut dominoes = dominoes.into_bytes();
        let n = dominoes.len();
        let mut force = vec![0; n];
        let mut f = 0;
        for i in 0..n {
            if dominoes[i] == b'R' {
                f = n;
            } else if dominoes[i] == b'L' {
                f = 0;
            } else {
                f = f.saturating_sub(1);
            }
            force[i] += f;
        }
        for i in (0..n).rev() {
            if dominoes[i] == b'L' {
                f = n;
            } else if dominoes[i] == b'R' {
                f = 0;
            } else {
                f = f.saturating_sub(1);
            }
            force[i] -= f;
        }
        for i in 0..n {
            dominoes[i] = match force[i] {
                x if x > 0 => b'R',
                x if x < 0 => b'L',
                _ => b'.',
            }
        }
        String::from_utf8(dominoes).unwrap()
    }
}