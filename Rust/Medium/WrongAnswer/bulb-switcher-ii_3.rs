impl Solution {
    pub fn flip_lights(n: i32, presses: i32) -> i32 {
        

        let n = n as usize;
        let presses = presses as usize;
        if n == 0 { return 0; }
        if n == 1 { return 2; }
        if n == 2 { return match presses {
            0 => 1,
            1 => 3,
            _ => 4,
        }; }
        if presses == 0 { return 1; }
        if presses == 1 { return 4; }
        if presses == 2 { return 7; }
        8
    }
}