impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        
        let mut reserved_seats = reserved_seats;
        reserved_seats.sort();
        let mut result = 0;
        let mut cur = 0;
        let mut prev = 0;
        for i in 0..reserved_seats.len() {
            if prev == 0 {
                prev = reserved_seats[i][0];
                cur = 0;
            }
            if prev != reserved_seats[i][0] {
                result += cur / 4;
                cur = 0;
                prev = reserved_seats[i][0];
            }
            let seat = reserved_seats[i][1];
            if seat == 2 || seat == 3 || seat == 4 || seat == 5 {
                cur |= 1;
            }
            if seat == 6 || seat == 7 || seat == 8 || seat == 9 {
                cur |= 2;
            }
            if seat == 4 || seat == 5 || seat == 6 || seat == 7 {
                cur |= 4;
            }
        }
        result += cur / 4;
        result += (n - reserved_seats.len() as i32) * 2;
        result
    }
}