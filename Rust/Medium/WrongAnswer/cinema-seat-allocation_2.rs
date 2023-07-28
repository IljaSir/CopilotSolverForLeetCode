impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        
        let mut reserved = vec![0; n as usize];
        for seat in reserved_seats {
            reserved[(seat[0] - 1) as usize] |= 1 << (seat[1] - 1);
        }
        let mut ans = (n * 2) as i32;
        for r in reserved {
            if r & 0b1111111110 == 0b1111111110 {
                ans -= 2;
            } else if r & 0b1111000000 == 0b1111000000 || r & 0b111100 == 0b111100 || r & 0b111100000000 == 0b111100000000 {
                ans -= 1;
            }
        }
        ans
    }
}