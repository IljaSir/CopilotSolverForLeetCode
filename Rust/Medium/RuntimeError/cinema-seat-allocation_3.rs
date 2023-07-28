impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        
        let mut seats = vec![vec![true; 11]; n as usize];
        for seat in reserved_seats {
            seats[seat[0] as usize - 1][seat[1] as usize] = false;
        }
        let mut res = 0;
        for seat in seats {
            let mut i = 1;
            let mut j = 4;
            let mut k = 7;
            let mut l = 10;
            let mut flag = 0;
            while j <= 10 {
                if seat[i] && seat[j] && seat[k] && seat[l] {
                    flag = 1;
                    break;
                }
                i += 1;
                j += 1;
                k += 1;
                l += 1;
            }
            if flag == 1 {
                if i == 1 || l == 10 {
                    res += 2;
                } else {
                    res += 1;
                }
            } else {
                res += 1;
            }
        }
        res
    }
}