impl Solution {
    pub fn flip_lights(n: i32, presses: i32) -> i32 {
        

        let n = n as usize;
        let presses = presses as usize;
        let mut states: Vec<usize> = (0..(1 << 4)).collect();
        for _ in 0..presses {
            states = states
                .iter()
                .map(|s| {
                    let mut s = *s;
                    s ^= 1;
                    s ^= 1 << 1;
                    s ^= 1 << 2;
                    s ^= 1 << 3;
                    s
                })
                .collect();
            states = states
                .iter()
                .map(|s| {
                    let mut s = *s;
                    if n >= 2 {
                        s ^= 1 << 1;
                    }
                    s
                })
                .collect();
            states = states
                .iter()
                .map(|s| {
                    let mut s = *s;
                    if n % 2 == 1 {
                        s ^= 1 << 2;
                    }
                    s
                })
                .collect();
            states = states
                .iter()
                .map(|s| {
                    let mut s = *s;
                    for i in (0..n).step_by(3) {
                        s ^= 1 << 3;
                    }
                    s
                })
                .collect();
        }
        states.sort();
        states.dedup();
        states.len() as i32
    }
}