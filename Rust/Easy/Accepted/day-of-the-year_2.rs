impl Solution {
    pub fn day_of_year(date: String) -> i32 {
        
        let mut v = date.split('-').collect::<Vec<&str>>();
        let y: i32 = v[0].parse().unwrap();
        let m: i32 = v[1].parse().unwrap();
        let d: i32 = v[2].parse().unwrap();
        let mut days = d;
        for i in 1..m {
            match i {
                1 => days += 31,
                2 => if y % 4 == 0 && (y % 100 != 0 || y % 400 == 0) { days += 29 } else { days += 28 },
                3 => days += 31,
                4 => days += 30,
                5 => days += 31,
                6 => days += 30,
                7 => days += 31,
                8 => days += 31,
                9 => days += 30,
                10 => days += 31,
                11 => days += 30,
                12 => days += 31,
                _ => (),
            }
        }
        days
    }
}