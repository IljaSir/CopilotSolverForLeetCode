impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        
        let mut seats = vec![vec![0; 10]; n as usize];
        for seat in reserved_seats {
            seats[seat[0] as usize - 1][seat[1] as usize - 1] = 1;
        }
        let mut ans = 0;
        for row in seats {
            let mut flag = 0;
            for i in 0..6 {
                if row[i] == 1 {
                    flag |= 1;
                }
            }
            for i in 2..8 {
                if row[i] == 1 {
                    flag |= 2;
                }
            }
            for i in 4..10 {
                if row[i] == 1 {
                    flag |= 4;
                }
            }
            ans += match flag {
                0 => 2,
                1 => 1,
                2 => 1,
                3 => 0,
                4 => 1,
                5 => 0,
                6 => 0,
                7 => 0,
                _ => panic!("invalid flag"),
            }
        }
        ans
    }
}