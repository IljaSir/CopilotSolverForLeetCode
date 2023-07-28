impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 0;
        let mut rows = std::collections::BTreeMap::new();
        for seat in reserved_seats {
            rows.entry(seat[0]).or_insert(vec![]).push(seat[1]);
        }
        for (_, seats) in rows {
            let mut seats = seats;
            seats.sort();
            let mut i = 0;
            while i < seats.len() {
                if seats[i] <= 2 {
                    i += 1;
                    continue;
                } else if seats[i] <= 6 {
                    ans += 1;
                    i += 1;
                    while i < seats.len() {
                        if seats[i] <= 6 {
                            i += 1;
                        } else {
                            break;
                        }
                    }
                } else if seats[i] <= 8 {
                    ans += 1;
                    i += 1;
                    while i < seats.len() {
                        if seats[i] <= 8 {
                            i += 1;
                        } else {
                            break;
                        }
                    }
                } else {
                    i += 1;
                }
            }
        }
        ans + (n - rows.len() as i32) * 2
    }
}