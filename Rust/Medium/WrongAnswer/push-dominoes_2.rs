impl Solution {
    pub fn push_dominoes(dominoes: String) -> String {
        
        let mut dominoes = dominoes.into_bytes();
        let n = dominoes.len();
        let mut forces = vec![0; n];
        let mut force = 0;
        for i in 0..n {
            if dominoes[i] == b'R' {
                force = n;
            } else if dominoes[i] == b'L' {
                force = 0;
            } else {
                force = force.saturating_sub(1);
            }
            forces[i] += force;
        }
        force = 0;
        for i in (0..n).rev() {
            if dominoes[i] == b'L' {
                force = n;
            } else if dominoes[i] == b'R' {
                force = 0;
            } else {
                force = force.saturating_sub(1);
            }
            forces[i] -= force;
        }
        for i in 0..n {
            dominoes[i] = if forces[i] > 0 {
                b'R'
            } else if forces[i] < 0 {
                b'L'
            } else {
                b'.'
            };
        }
        unsafe { String::from_utf8_unchecked(dominoes) }
    }
}