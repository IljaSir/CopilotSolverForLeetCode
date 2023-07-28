impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        
        let mut n = n as i64;
        let mut reserved_seats = reserved_seats;
        reserved_seats.sort();
        let mut i = 0;
        let mut ans = 0;
        while i < reserved_seats.len() {
            let mut j = i;
            while j < reserved_seats.len() && reserved_seats[j][0] == reserved_seats[i][0] {
                j += 1;
            }
            ans += 2 * (j - i) as i64;
            let mut left = true;
            let mut right = true;
            for k in i..j {
                if reserved_seats[k][1] >= 2 && reserved_seats[k][1] <= 5 {
                    left = false;
                }
                if reserved_seats[k][1] >= 6 && reserved_seats[k][1] <= 9 {
                    right = false;
                }
            }
            if left {
                ans -= 1;
            }
            if right {
                ans -= 1;
            }
            i = j;
        }
        ans + 2 * n
    }
}