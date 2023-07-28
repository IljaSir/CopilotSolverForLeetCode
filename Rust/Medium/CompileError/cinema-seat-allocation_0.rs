impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        
        let mut reserved = vec![vec![false; 10]; n as usize];
        for seat in reserved_seats {
            reserved[seat[0] as usize - 1][seat[1] as usize - 1] = true;
        }
        let mut count = 0;
        for row in reserved {
            let mut left = 0;
            let mut right = 0;
            if !row[1] && !row[2] && !row[3] && !row[4] {
                left = 1;
            }
            if !row[5] && !row[6] && !row[7] && !row[8] {
                right = 1;
            }
            if !row[3] && !row[4] && !row[5] && !row[6] {
                count += 1;
                continue;
            }
            count += left + right;
        }
        count + (n - reserved.len() as i32) * 2
    }
}