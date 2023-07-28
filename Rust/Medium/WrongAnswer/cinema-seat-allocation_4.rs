impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for seat in reserved_seats {
            map.entry(seat[0]).or_insert(vec![]).push(seat[1]);
        }
        let mut res = 0;
        for seat in map.values() {
            let mut flag = 0;
            for j in 2..=9 {
                if seat.contains(&j) {
                    flag = 1;
                    break;
                }
            }
            if flag == 0 {
                res += 2;
            } else {
                let mut flag = 0;
                for j in 2..=5 {
                    if seat.contains(&j) {
                        flag = 1;
                        break;
                    }
                }
                if flag == 0 {
                    res += 1;
                }
                let mut flag = 0;
                for j in 6..=9 {
                    if seat.contains(&j) {
                        flag = 1;
                        break;
                    }
                }
                if flag == 0 {
                    res += 1;
                }
            }
        }
        res + (n - map.len() as i32) * 2
    }
}