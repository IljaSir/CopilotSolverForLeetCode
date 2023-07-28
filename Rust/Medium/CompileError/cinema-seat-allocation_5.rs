impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        for v in reserved_seats {
            let e = map.entry(v[0]).or_insert(0);
            *e |= 1 << (10 - v[1]);
        }
        for (_, v) in map {
            if v & 0b1111111100 == 0 {
                res += 2;
            } else if v & 0b1111000000 == 0 || v & 0b0000111100 == 0 || v & 0b0000001111 == 0 {
                res += 1;
            }
        }
        res += (n - map.len() as i32) * 2;
        res
    }
}